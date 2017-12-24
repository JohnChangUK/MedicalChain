import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class BlockChain {

    public static List<Block> blockchain = new ArrayList<Block>();
    public static int difficulty = 2;

    public static void main(String[] args) {
        //add our blocks to the blockchain ArrayList:
        blockchain.add(new Block("Genesis Block", "0"));
        System.out.println("Mining the Genesis Block...");
        blockchain.get(0).mineBlock(difficulty);

        blockchain.add(new Block("Second Block",blockchain.get(blockchain.size() - 1).hash));
        System.out.println("Mining the Second Block...");
        blockchain.get(1).mineBlock(difficulty);

        blockchain.add(new Block("Third Block",blockchain.get(blockchain.size() - 1).hash));
        System.out.println("Mining the Third Block...");
        blockchain.get(2).mineBlock(difficulty);

        System.out.println("\nBlockchain is Valid: " + isChainValid());

        String jsonBlockChain = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println(jsonBlockChain);
    }

    public static Boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;
        String hashGoal = new String(new char[difficulty]).replace('\0', '0');

        for (int i = 1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i - 1);

            if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
                System.out.println("Current Hashes are NOT equal");
                return false;
            }

            if (!previousBlock.hash.equals(currentBlock.previousHash)) {
                System.out.println("Previous Hashes are NOT equal");
                return false;
            }

            if (!currentBlock.hash.substring(0, difficulty).equals(hashGoal)) {
                System.out.println("This Block has NOT been mined");
                return false;
            }
        }
        return true;
    }
}
