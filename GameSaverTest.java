import java.io.*;

public class GameSaverTest{

    public static void main(String[] args){
        GameCharacter one = new GameCharacter(50, "Elf", new String[] {"bow", "sword", "dust"});
        GameCharacter two = new GameCharacter(200, "Troll", new String[] {"bare hands", "big ax"});
        GameCharacter three = new GameCharacter(120, "Magician", new String[] {"spells", "invisibility"});

        try{
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Game.ser"));
            os.writeObject(one);
            os.writeObject(two);
            os.writeObject(three);
            os.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        one = null;
        two = null;
        three = null;

        try{
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("Game.ser"));
            GameCharacter restoreOne = (GameCharacter)is.readObject();
            GameCharacter restoreTwo = (GameCharacter)is.readObject();
            GameCharacter restoreThree = (GameCharacter)is.readObject();

            System.out.println("One’s type: " + restoreOne.getType());
            System.out.println("Two’s type: "+ restoreTwo.getType());
            System.out.println("Three’s type: " + restoreThree.getType());

            is.close();

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}