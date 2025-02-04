import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class Node implements Comparable<Node> {
    int frequency;
    char character;
    Node left, right;

    Node(int frequency, char character) {
        this.frequency = frequency;
        this.character = character;
    }

    Node(int frequency, Node left, Node right) {
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.frequency, other.frequency);
    }
}

public class HuffmanCoding {

    public static void main(String[] args) {
        HuffmanCoding hc = new HuffmanCoding();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 1 for compression or 2 for decompression:");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.println("Enter the filenames (separated by spaces):");
        String[] filenames = scanner.nextLine().split(" ");

        if (choice == 1) {
            for (String filename : filenames) {
                try {
                    String text = hc.readFile(filename);
                    Map<Character, Integer> frequencyTable = hc.createFrequencyTable(text);
                    Node huffmanTree = hc.buildHuffmanTree(frequencyTable);
                    Map<Character, String> huffmanCodes = new HashMap<>();
                    hc.createHuffmanCodes(huffmanTree, "", huffmanCodes);
                    String encodedText = hc.huffmanEncoding(text, huffmanCodes);

                    String outputFilename = filename + ".huffman";
                    hc.writeFile(outputFilename, encodedText);
                    System.out.println("File " + filename + " compressed to " + outputFilename);

                    // Save the codes to a file
                    hc.writeHuffmanCodes(filename + ".codes", huffmanCodes);

                } catch (IOException e) {
                    System.out.println("Error processing file " + filename + ": " + e.getMessage());
                }
            }
        } else if (choice == 2) {
            for (String filename : filenames) {
                try {
                    String encodedText = hc.readFile(filename);
                    Map<Character, String> huffmanCodes = hc.readHuffmanCodes(filename.replace(".huffman", ".codes"));
                    Node huffmanTree = hc.buildHuffmanTreeFromCodes(huffmanCodes);
                    String decodedText = hc.huffmanDecoding(encodedText, huffmanTree);

                    String outputFilename = filename.replace(".huffman", ".decoded");
                    hc.writeFile(outputFilename, decodedText);
                    System.out.println("File " + filename + " decompressed to " + outputFilename);

                } catch (IOException e) {
                    System.out.println("Error processing file " + filename + ": " + e.getMessage());
                }
            }
        } else {
            System.out.println("Invalid choice.");
        }

        scanner.close();
    }

    public String readFile(String filename) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString().trim(); // حذف خط جدید اضافی در انتها
    }

    public void writeFile(String filename, String content) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(content);
        }
    }

    public void writeHuffmanCodes(String filename, Map<Character, String> huffmanCodes) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            for (Map.Entry<Character, String> entry : huffmanCodes.entrySet()) {
                writer.write(entry.getKey() + "=" + entry.getValue() + "\n");
            }
        }
    }

    public Map<Character, String> readHuffmanCodes(String filename) throws IOException {
        Map<Character, String> huffmanCodes = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] entry = line.split("=");
                huffmanCodes.put(entry[0].charAt(0), entry[1]);
            }
        }
        return huffmanCodes;
    }

    public Map<Character, Integer> createFrequencyTable(String text) {
        Map<Character, Integer> frequencyTable = new HashMap<>();
        for (char c : text.toCharArray()) {
            frequencyTable.put(c, frequencyTable.getOrDefault(c, 0) + 1);
        }
        return frequencyTable;
    }

    public Node buildHuffmanTree(Map<Character, Integer> frequencyTable) {
        PriorityQueue<Node> heap = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : frequencyTable.entrySet()) {
            heap.add(new Node(entry.getValue(), entry.getKey()));
        }

        while (heap.size() > 1) {
            Node left = heap.poll();
            Node right = heap.poll();
            Node newNode = new Node(left.frequency + right.frequency, left, right);
            heap.add(newNode);
        }

        return heap.poll();
    }

    public void createHuffmanCodes(Node node, String code, Map<Character, String> codes) {
        if (node == null) return;

        if (node.left == null && node.right == null) {
            codes.put(node.character, code);
        }

        createHuffmanCodes(node.left, code + '0', codes);
        createHuffmanCodes(node.right, code + '1', codes);
    }

    public String huffmanEncoding(String text, Map<Character, String> codes) {
        StringBuilder encodedText = new StringBuilder();
        for (char c : text.toCharArray()) {
            encodedText.append(codes.get(c));
        }
        return encodedText.toString();
    }

    public String huffmanDecoding(String encodedText, Node root) {
        StringBuilder decodedText = new StringBuilder();
        Node currentNode = root;

        for (char bit : encodedText.toCharArray()) {
            currentNode = (bit == '0') ? currentNode.left : currentNode.right;

            if (currentNode.left == null && currentNode.right == null) {
                decodedText.append(currentNode.character);
                currentNode = root;
            }
        }

        return decodedText.toString();
    }

    public Node buildHuffmanTreeFromCodes(Map<Character, String> huffmanCodes) {
        Node root = new Node(0, '\0');

        for (Map.Entry<Character, String> entry : huffmanCodes.entrySet()) {
            Node currentNode = root;
            String code = entry.getValue();

            for (char bit : code.toCharArray()) {
                if (bit == '0') {
                    if (currentNode.left == null) {
                        currentNode.left = new Node(0, '\0');
                    }
                    currentNode = currentNode.left;
                } else {
                    if (currentNode.right == null) {
                        currentNode.right = new Node(0, '\0');
                    }
                    currentNode = currentNode.right;
                }
            }
            currentNode.character = entry.getKey();
        }

        return root;
    }
}
