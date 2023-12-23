package DSLab_finalwork;

/**
 * @author 刘浩彬
 * @date 2023/12/21
 */
import java.util.*;

// 定义Huffman节点类，用于构建Huffman树
class HuffmanNode implements Comparable<HuffmanNode> {
    char character;
    int frequency;
    HuffmanNode left, right;

    // 构造方法1：叶子节点，包含字符和频率
    public HuffmanNode(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
    }

    // 构造方法2：非叶子节点，包含字符、频率以及左右子节点
    public HuffmanNode(char character, int frequency, HuffmanNode left, HuffmanNode right) {
        this.character = character;
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }

    // 实现Comparable接口，用于优先队列的比较
    @Override
    public int compareTo(HuffmanNode node) {
        return this.frequency - node.frequency;
    }
}

// 定义Huffman编码和解码类
class HuffmanEncoderDecoder {
    // 构建字符频率表和生成Huffman编码
    public Map<Character, String> buildFrequencyTable(String text) {
        Map<Character, Integer> frequencyTable = new HashMap<>();

        // 统计字符频率
        for (char c : text.toCharArray()) {
            frequencyTable.put(c, frequencyTable.getOrDefault(c, 0) + 1);
        }

        // 使用优先队列（最小堆）构建Huffman树
        PriorityQueue<HuffmanNode> minHeap = new PriorityQueue<>();
        for (char c : frequencyTable.keySet()) {
            minHeap.offer(new HuffmanNode(c, frequencyTable.get(c)));
        }

        while (minHeap.size() > 1) {
            HuffmanNode left = minHeap.poll();
            HuffmanNode right = minHeap.poll();
            HuffmanNode parent = new HuffmanNode('\0', left.frequency + right.frequency, left, right);
            minHeap.offer(parent);
        }

        // 生成Huffman编码
        Map<Character, String> huffmanCodes = new HashMap<>();
        if (!minHeap.isEmpty()) {
            generateHuffmanCodes(minHeap.peek(), "", huffmanCodes);
        }

        return huffmanCodes;
    }

    // 递归生成Huffman编码
    private void generateHuffmanCodes(HuffmanNode node, String code, Map<Character, String> huffmanCodes) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            huffmanCodes.put(node.character, code);
        }

        generateHuffmanCodes(node.left, code + "0", huffmanCodes);
        generateHuffmanCodes(node.right, code + "1", huffmanCodes);
    }

    // 使用Huffman编码对文本进行编码
    public String encode(String text, Map<Character, String> huffmanCodes) {
        StringBuilder encodedText = new StringBuilder();
        for (char c : text.toCharArray()) {
            encodedText.append(huffmanCodes.get(c));
        }
        return encodedText.toString();
    }

    // 使用Huffman编码对编码后的文本进行解码
    public String decode(String encodedText, HuffmanNode root) {
        StringBuilder decodedText = new StringBuilder();
        HuffmanNode currentNode = root;

        // 遍历编码字符串，根据0和1移动Huffman树的节点
        for (char c : encodedText.toCharArray()) {
            if (c == '0') {
                currentNode = currentNode.left;
            } else if (c == '1') {
                currentNode = currentNode.right;
            }

            // 到达叶子节点时，添加字符到解码结果，并重置节点为根节点
            if (currentNode.left == null && currentNode.right == null) {
                decodedText.append(currentNode.character);
                currentNode = root;
            }
        }
        return decodedText.toString();
    }
}

// 示例类，展示Huffman编码和解码的用法
public class HuffmanEncoderDecoderExample {
    public static void main(String[] args) {
        String text = "Hello, Huffman!";

        HuffmanEncoderDecoder encoderDecoder = new HuffmanEncoderDecoder();

        // 构建频率表和Huffman编码
        Map<Character, String> huffmanCodes = encoderDecoder.buildFrequencyTable(text);

        // 打印每个字符及其对应的Huffman编码
        for (char c : huffmanCodes.keySet()) {
            System.out.println("'" + c + "' : " + huffmanCodes.get(c));
        }

        // 使用Huffman编码对文本进行编码
        String encodedText = encoderDecoder.encode(text, huffmanCodes);
        System.out.println("Encoded Text: " + encodedText);

        // 构建Huffman树
        PriorityQueue<HuffmanNode> minHeap = new PriorityQueue<>(huffmanCodes.values().size());
        for (char c : huffmanCodes.keySet()) {
            minHeap.offer(new HuffmanNode(c, 0)); // 频率在构建Huffman树时不需要
        }

        while (minHeap.size() > 1) {
            HuffmanNode left = minHeap.poll();
            HuffmanNode right = minHeap.poll();
            HuffmanNode parent = new HuffmanNode('\0', left.frequency + right.frequency, left, right);
            minHeap.offer(parent);
        }

        // 获取Huffman树的根节点
        HuffmanNode root = minHeap.peek();

        // 使用Huffman编码对编码后的文本进行解码
        String decodedText = encoderDecoder.decode(encodedText, root);
        System.out.println("Decoded Text: " + decodedText);
    }
}
