import java.util.Arrays;

/**
 * A very basic Player class that extends to the person class
 *
 * @author	Sean Morgan
 * @version	1.0
 */

public class Player extends Person {
    private String GE_ZERO = "property must be greater than or equal to 0";
    protected Integer assists;
    protected Integer goals; // Can be points based on sport
    protected Integer losses;
    private String[] ratings = {"Beginner", "Intermediate", "Expert"};
    protected String skillRating;
    protected String team;
    protected Integer ties;
    protected Integer wins;


    /**
     * No argument constructor that creates a generic Player object
     */
    public Player()
    {
        setFirstName("Jane");
        setLastName("Doe");
        middleName = null;
        courtesyTitle = null;
        suffix = null;
        System.out.println(Gender.MALE);
        setGender(Gender.MALE.toString());
        setAge((byte)0);
        setAssists(0);
        setGoals(0);
        setLosses(0);
        setSkillRating(ratings[0]);
        team = null;
        setTies(0);
        setWins(0);
    }


    /**
     * Standard information constructor
     * First Name, Last Name, Gender, Age, Skill Rating, and Team
     */
    public Player(String fN, String lN, String gen,
                  Byte ag, String rate, String team)
    {
        setFirstName(fN);
        setLastName(lN);
        middleName = null;
        courtesyTitle = null;
        suffix = null;
        setGender(gen);
        setAge(ag);
        setAssists(0);
        setGoals(0);
        setLosses(0);
        setSkillRating(rate);
        setTeam(team);
        setTies(0);
        setWins(0);
    }

    /**
     * Complete information constructor
     * First Name, Last Name, Middle Name, Courtesy Title,
     * Suffix, Gender, Age, Assists, Goals, Losses,
     * Skill Rating, Team, Ties, and Wins
     */
    public Player(String fN, String lN, String mN, String title, String suf,
                  String gen, Byte ag, Integer as, Integer g, Integer l,
                  String rate, String te, Integer ti, Integer w)
    {
        setFirstName(fN);
        setLastName(lN);
        setMiddleName(mN);
        setCourtesyTitle(title);
        setSuffix(suf);
        setGender(gen);
        setAge(ag);
        setAssists(as);
        setGoals(g);
        setLosses(l);
        setSkillRating(rate);
        setTeam(te);
        setTies(ti);
        setWins(w);
    }


    public boolean contains(String context, String[] stringList) {
        /**
         * @param context
         * @param stringList
         * Iterates through the stringList to see if the context exists
         * If context exists within the stringList return true
         * otherwise return false
         * @returns boolean
         */
        for (int i = 0; i < stringList.length; i++) {
            if (context.equals(stringList[i])) {
                return true;
            }
        }
        return false;
    }

    public Integer getAssists() {
        /**
         * @Returns assists within the instance
         */
        return this.assists;
    }

    public Integer getGoals() {
        /**
         * @Returns goals within the instance
         */
        return this.goals;
    }

    public Integer getLosses() {
        /**
         * @Returns losses within the instance
         */
        return this.losses;
    }

    public String getSkillRating() {
        /**
         * @Returns skillRating within the instance
         */
        return this.skillRating;
    }

    public String getTeam() {
        /**
         * @Returns team within the instance
         */
        return this.team;
    }

    public Integer getTies() {
        /**
         * @Returns ties within the instance
         */
        return this.ties;
    }

    public Integer getWins() {
        /**
         * @Returns wins within the instance
         */
        return this.wins;
    }

    public void setAssists(Integer assists) {
        /**
         * @param assists
         * Checks if assists is greater than or equal to 0
         * Sets assists within the instance
         * @throws IllegalArgumentException if negative value
         */
        if (assists >= 0) {
            this.assists = assists;
        } else {
            throw new IllegalArgumentException(String.format("Assists %s", GE_ZERO));
        }
    }

    public void setGoals(Integer goals) {
        /**
         * @param goals
         * Checks if goals is greater than or equal to 0
         * Sets goals within the instance
         * @throws IllegalArgumentException if negative value
         */
        if (goals >= 0) {
            this.goals = goals;
        } else {
            throw new IllegalArgumentException(String.format("Goals %s", GE_ZERO));
        }
    }


    public void setLosses(Integer losses) {
        /**
         * @param losses
         * Checks if losses is greater than or equal to 0
         * Sets losses within the instance
         * @throws IllegalArgumentException if negative value
         */
        if (losses >= 0) {
            this.losses = losses;
        } else {
            throw new IllegalArgumentException(String.format("Losses %s", GE_ZERO));
        }
    }

    public void setSkillRating(String rating) {
        /**
         * @param rating
         * Checks if rating exists within the instance object's set of ratings
         * Sets skillRating within the instance
         * @throws IllegalArgumentException if rating doesn't exist in ratings
         */
        if (contains(rating, this.ratings)) {
            this.skillRating = rating;
        }
        else {
            throw new IllegalArgumentException("Skill Rating needs to be a choice of " + Arrays.toString(this.ratings));
        }
    }

    public void setTeam(String team) {
        /**
         * @param team
         * Sets team within the instance
         * @throws IllegalArgumentException if null
         */
        if (team != null) {
            this.team = team;
        } else {
            throw new IllegalArgumentException("Team property must have a value");
        }
    }

    public void setTies(Integer ties) {
        /**
         * @param ties
         * Checks if ties is greater than or equal to 0
         * Sets ties within the instance
         * @throws IllegalArgumentException if negative value
         */
        if (ties >= 0) {
            this.ties = ties;
        } else {
            throw new IllegalArgumentException(String.format("Ties %s", GE_ZERO));
        }
    }

    public void setWins(Integer wins) {
        /**
         * @param wins
         * Checks if wins is greater than or equal to 0
         * Sets wins within the instance
         * @throws IllegalArgumentException if negative value
         */
        if (wins >= 0) {
            this.wins = wins;
        } else {
            throw new IllegalArgumentException(String.format("Wins %s", GE_ZERO));
        }
    }
}
