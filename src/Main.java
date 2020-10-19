import javax.swing.*; // Easier GUI creation
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

class GUI extends JFrame {
    final int COLUMN_SIZE = 20;
    String labelText;
    JButton confirmButton;
    JFrame frame;

    public GUI() {
        super("Person Form - Sean Morgan Hw3"); // Sets title of window
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Destroys window after exit
        this.setVisible(true);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null); // Centers window onto screen
        this.frame = this;

    }

    private void run() {
        List<JLabel> labels = new ArrayList<>();
        List<JTextField> textFields = new ArrayList<>();
        Field allFields[] = Person.class.getDeclaredFields(); // Grabs fields of Person
        Field fields[] = Player.class.getDeclaredFields(); // Grabs fields of Player

        for (int i = 0; i < fields.length; i++) {
            allFields = addedArray(allFields.length, allFields, fields[i]);
            // Combines the Person and Player Fields into a single array
        }

        this.setLayout(new GridLayout((int) allFields.length / 2 + allFields.length % 2, 2));
        // Sizes the height of the GridLayout

        for (int i = 0; i < allFields.length - 1; i++) { // -1 to not include ratings, the last field
            labelText = formalizeText(allFields[i].getName());
            // Formats the fields' text to come out as First Name, Last Name, etc.
            JLabel label = new JLabel(labelText); // Creates Label
            labels.add(label); // Adds Label to Array
            this.add(labels.get(i)); // Adds Label to GUI
            textFields.add(new JTextField(this.COLUMN_SIZE)); // Adds the new text field to an array
            this.add(textFields.get(i)); // Adds TextField to GUI that is corresponding to its label
        }
        confirmButton = new JButton("Display Player Object");
        JTextField[] finalTextFields = textFields.toArray(new JTextField[0]);
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // Didn't know how to pass an array to split into the constructor.
                // Similar to python usage passing an array with *
                // *[finalTextFields[i].getText() for i in range(len(finalTextFields))] # Python Usage
                // Brute Force to getting the text from the Text Fields
                byte ag = 0;
                Integer as = 0, g = 0, l = 0, t = 0, w = 0;
                Player p = new Player();

                String fName = finalTextFields[0].getText();
                String lName = finalTextFields[1].getText();
                String mName = finalTextFields[2].getText();
                String courtesyTitle = finalTextFields[3].getText();
                String suffix = finalTextFields[4].getText();
                String gender = finalTextFields[5].getText();
                String age = finalTextFields[6].getText();
                String team = finalTextFields[7].getText();
                String skillRating = finalTextFields[8].getText();
                String wins = finalTextFields[9].getText();
                String losses = finalTextFields[10].getText();
                String ties = finalTextFields[11].getText();
                String goal = finalTextFields[12].getText();
                String assist = finalTextFields[13].getText();

                /**
                 * First Name, Last Name, Middle Name, Courtesy Title,
                 * Suffix, Gender, Age, Assists, Goals, Losses,
                 * Skill Rating, Team, Ties, and Wins
                 */

                try {

                    if (parseByte(age) != Byte.MAX_VALUE) {ag = parseByte(age);}
                    else {throw new IllegalArgumentException("All Person objects must be at least 0 years of age");} // Display Dialog Box being an error
                    if (parseInteger(assist) != Integer.MAX_VALUE) {as = parseInteger(assist);}
                    else {throw new IllegalArgumentException(String.format("Assists %s", "property must be greater than or equal to 0"));} // Display Dialog Box being an error
                    if (parseInteger(goal) != Integer.MAX_VALUE) {g = parseInteger(goal);}
                    else {throw new IllegalArgumentException(String.format("Goals %s", "property must be greater than or equal to 0"));} // Display Dialog Box being an error
                    if (parseInteger(losses) != Integer.MAX_VALUE) {l = parseInteger(losses);}
                    else {throw new IllegalArgumentException(String.format("Losses %s", "property must be greater than or equal to 0"));} // Display Dialog Box being an error
                    if (parseInteger(ties) != Integer.MAX_VALUE) {t = parseInteger(ties);}
                    else {throw new IllegalArgumentException(String.format("Ties %s", "property must be greater than or equal to 0"));} // Display Dialog Box being an error
                    if (parseInteger(wins) != Integer.MAX_VALUE) {w = parseInteger(wins);}
                    else {throw new IllegalArgumentException(String.format("Wins %s", "property must be greater than or equal to 0"));} // Display Dialog Box being an error
                    p.setFirstName(fName);
                    p.setLastName(lName);
                    p.setMiddleName(mName);
                    p.setCourtesyTitle(courtesyTitle);
                    p.setSuffix(suffix);
                    p.setGender(gender);
                    p.setAge(ag);
                    p.setAssists(as);
                    p.setGoals(g);
                    p.setLosses(l);
                    p.setSkillRating(skillRating);
                    p.setTeam(team);
                    p.setTies(t);
                    p.setWins(w);
                }
                catch (IllegalArgumentException e) {
                    System.out.println("Error Provided : " + e);
                    JDialog d = new JDialog(frame, "Invalid Arguement");
                    JLabel label = new JLabel("<html><body><p style='width: 65%; margin : 2%;'>Error Provided : " + e + "</p></body></html>");
                    d.add(label);
                    d.setSize(300,300);
                    d.setVisible(true);
                    d.setLocationRelativeTo(null); // Centers window onto screen
                    return;

                }
                JDialog d = new JDialog(frame, "Player Object Created");
                JLabel label = new JLabel("<html><body><p style='width: 65%; margin : 2%;'>Player Object Created : " +
                        p.toString() + "\n\n" + p.asString()
                        + "</p></body></html>");
                d.add(label);
                d.setSize(300,300);
                d.setVisible(true);
                d.setLocationRelativeTo(null); // Centers window onto screen
            }

        });

        this.add(confirmButton);
        // Confirmation Button, Onclick sends a dialog box displaying the contents created.

        this.pack();
    }

    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.run();
    }

    public static Integer parseInteger(String s) {
        Integer integer;
        try {
            integer = Integer.parseInt(s);
        }
        catch (NumberFormatException e){
            // Output dialog being incorrect on assists
            return Integer.MAX_VALUE;
        }
        return integer;
    }

    public static byte parseByte(String s) {
        byte by;
        try {
            by = Byte.parseByte(s);
        }
        catch (NumberFormatException e){
            // Output dialog being incorrect on assists
            return Byte.MAX_VALUE;
        }
        return by;
    }



    public static Field[] addedArray(int length, Field fields[], Field addedField) {
        /**
         * @param length
         * @param fields[]
         * @param addedField
         * @returns The original array's contents with a new Field object added at the end.
         */
        Field newFields[] = new Field[length + 1];
        for (int i = 0; i < length; i++) {
            newFields[i] = fields[i];
        }
        newFields[length] = addedField;
        return newFields;
    }

    public static String formalizeText(String s) {
        String words[] = s.split("(?=\\p{Upper})"); // Assuming ?=\\p is a command being the search target and
        // if the character is uppercase, it will split by that standard
        // Having similar issue trying to do charAt(0).toUpperCase() or even indexing the string didn't work
        // Also tried substrings which didn't seem to work for me, "User error" on my part most likely.
        // https://stackoverflow.com/questions/3904579/how-to-capitalize-the-first-letter-of-a-string-in-java
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
        }
        return String.join(" ", words);
    }
}
