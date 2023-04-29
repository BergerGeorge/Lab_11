import java.util.ArrayList;
import java.util.Scanner;
public class ListMaker
{
    static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);

        final String menu = "A - Add D - Delete P - Print Q - Quit";
        boolean done = false;
        String cmd = "";
        String item = "";
        boolean quit = false;
        int itemNumber = 0;
        do
        {
            //display the list
            displayList();
            //display the menu options
            // get a menu choice
            cmd = SafeInput.getRegExString(console, menu, "[AaDdPpQq]");
            cmd = cmd.toUpperCase();
            //execute the choice
            switch(cmd)
            {
                case "A":
                    // Prompt the user for a list item
                    //make sure that it is not an empty string

                    item = SafeInput.getNonZeroLenString(console, item);

                    // Add it to the list
                    list.add(item);
                    break;
                case "D":
                    // Prompt the User for the number of the item to delete
                    itemNumber = SafeInput.getInt(console, "Enter the number of the item you would like to delete");
                    // Translate the number to an index by subtracting one
                    itemNumber = itemNumber -1;
                    System.out.println("item number is " +itemNumber);
                    //remove the item from the list
                    list.remove(itemNumber);
                    break;
                case "P":
                    ListMaker.displayList();
                    break;
                case "Q":
                    quit = SafeInput.getYNConfirm(console, "Are you sure you want to quit?");
                    while (!quit);
                    System.exit(0);
                    break;
            }
            System.out.println("The command you entered is: "+cmd);


        }
        while(!done);


    }

    private static void displayList()
    {
        System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++");
        if(list.size() != 0 )
        {
            for(int i = 0; i < list.size(); i++)
            {
                System.out.printf("\n%3d%35s", i+1, list.get(i) );
            }

        }
        else
            System.out.println("+++               List is Empty               +++");
        System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++");
    }
}

