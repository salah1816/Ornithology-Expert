package modal;

import java.util.HashMap;

public class Clause {
    private static HashMap<Character, String> clauses = new HashMap<>();

    public static HashMap<Character, String> getClauses() {
        clauses.put('A',"vole");
        clauses.put('B',"pond des oeufs");
        clauses.put('C',"a des pulmes");
        clauses.put('D',"a un long cou");
        clauses.put('E',"a des langues pattes");
        clauses.put('F',"est un oiseau");
        clauses.put('G',"est un autruche");
        return clauses;
    }
}
