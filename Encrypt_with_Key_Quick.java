import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Neyo
 */
public class LearningJava
{
    
    public static void main(String[] args) {
    
        
        
        //Ask for encrypt or decrypt
        System.out.println("Do you wish to encrypt or decrypt?: ");
        Scanner getUserInput = new Scanner(System.in);
        String ans = getUserInput.next();
        
        //ENCRYPTION
        if(ans.equalsIgnoreCase("encrypt"))
        {
            int[] EncryptionKey = new int[0];
            //Creates a key using the users input
            System.out.println("Please enter your encryption key: ");
            Scanner getUserInput2 = new Scanner(System.in);
            //Get the key from the user
            String key = getUserInput2.next();
    
            //Display the key
            System.out.println("key accepted: " + key);
            System.out.print("converting key");
            for (int z = 0; z < 3; z++)
            {
                try
                {
                    Thread.sleep(500);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                System.out.print(".");
            }
            System.out.println();
            //Create an integer array to store the key
            int[] storeKey = new int[key.length()];
    
            //Go through the string key and convert each character to an Integer that goes into the storeKey array
            for(int index = 0 ; index < key.length() ; index++){
                storeKey[index] = Integer.parseInt(String.valueOf(key.charAt(index)));
            }
    
            //Print out the string key as array of integers after conversion
            System.out.println(Arrays.toString(storeKey));
    
            //Store that integer we created as the variable in the object
            EncryptionKey = storeKey;
            System.out.println();
            System.out.println("Write a message to be encrypted: ");
            Scanner getUserMessage = new Scanner(System.in);
            String message = getUserMessage.nextLine();
            System.out.println();
    
            Integer keyValue;
            String encoded = "", decoded = "";
    
    
            Queue<Integer> encodingQueue = new LinkedList<Integer>();
            Queue<Integer> decodingQueue = new LinkedList<Integer>();
    
    
            for (int scan = 0; scan < EncryptionKey.length; scan++)
            {
                encodingQueue.add(EncryptionKey[scan]);
                decodingQueue.add(EncryptionKey[scan]);
            }
            // encode message
            for (int scan = 0; scan < message.length(); scan++)
            {
                keyValue = encodingQueue.remove();
                encoded += (char) (message.charAt(scan) + keyValue);
                encodingQueue.add(keyValue);
            }
            System.out.print("Encoding Message");
            for (int z = 0; z < 3; z++)
            {
                try
                {
                    Thread.sleep(500);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                System.out.print(".");
            }
            System.out.println();
            System.out.println("ENCRYPTED: " + encoded);
            
        }
        
        //DECRYPTION
        else if (ans.equalsIgnoreCase("decrypt"))
        {
            int[] EncryptionKey = new int[0];
            //Creates a key using the users input
            System.out.println("Please enter your encryption key: ");
            Scanner getUserInput3 = new Scanner(System.in);
            //Get the key from the user
            String key = getUserInput3.next();
            
            //Display the key
            System.out.println("key accepted: " + key);
            System.out.print("converting key");
            for (int z = 0; z < 3; z++)
            {
                try
                {
                    Thread.sleep(500);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                System.out.print(".");
            }
            System.out.println();
    
            //Create an integer array to store the key
            int[] storeKey = new int[key.length()];
    
            //Go through the string key and convert each character to an Integer that goes into the storeKey array
            for(int index = 0 ; index < key.length() ; index++){
                storeKey[index] = Integer.parseInt(String.valueOf(key.charAt(index)));
            }
    
            //Print out the string key as array of integers after conversion
            System.out.println(Arrays.toString(storeKey));
    
            //Store that integer we created as the variable in the object
            EncryptionKey = storeKey;
            System.out.println();
            System.out.println("Enter a message to be decrypted: ");
            Scanner getUserMessage = new Scanner(System.in);
            String message = getUserMessage.nextLine();
            System.out.println();
    
            Integer keyValue;
            String decoded = "";
    
    
            Queue<Integer> decodingQueue = new LinkedList<Integer>();
            // load key queues
    
            for (int scan = 0; scan < EncryptionKey.length; scan++)
            {
                decodingQueue.add(EncryptionKey[scan]);
            }
            // decode message just subtract the key from it
            for (int scan = 0; scan < message.length(); scan++)
            {
                keyValue = decodingQueue.remove();
                decoded += (char) (message.charAt(scan) - keyValue);
                decodingQueue.add(keyValue);
            }
            System.out.print("Decoding Message");
            for (int z = 0; z < 3; z++)
            {
                try
                {
                    Thread.sleep(500);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                System.out.print(".");
            }
            System.out.println();
            System.out.println("DECRYPTED: " + decoded);
        }
        
        else
            System.out.println("invalid");
    
    }
}

