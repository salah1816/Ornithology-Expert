package modal;

import static modal.Main.baseDesFaits;
import static modal.Clause.getClauses;
import java.util.ArrayList;
import java.util.HashMap;

public class Premise {
    protected static HashMap<Character, String> clauses = new HashMap<>();
    ArrayList<String> premises=new ArrayList<>(); //ici on stocke les premises de chaque règles dont les index represente
                                                //le numéro de la règle moins un

    public Premise() {

//        rules.put("A","se sentir bouleversé");
//        rules.put("B","peur persistante");
//        rules.put("C","s'attendre à ce que quelque chose se produise");
//        rules.put("D","absence de conscience");
//        rules.put("E","peur de l'accumulation de saleté");
//        rules.put("F","fermer les portes en permanence");
//        rules.put("G","perte de mémoire temporaire");
//        rules.put("H","désalignement des membres");
//        rules.put("I","déséquilibre alimentaire");
//        rules.put("J","fréquence de prise de décision");
//        rules.put("K","spasmes musculaires");
//        rules.put("L","idées et questions");
//        rules.put("M","perdre espoir Se laver les mains fréquemment");
//        rules.put("N","augmentation de la sécrétion d'adrénaline");
//        rules.put("O","le sentiment de haine");
//        rules.put("P","Se doucher plus d'une fois");
//        rules.put("Q","inactivité du corps");
//        rules.put("R","pressions de la vie");
//        rules.put("S","peur de l'inconnu");
//        rules.put("T","hypertension");
//        rules.put("V","répéter le lavage des mains");
//        rules.put("W","sentiment constant de la frustration et perte d'espoir");
//        rules.put("X","perte de la jouissance de la vie et absence de prise de décision");
//        maladies.put("W","dépression");
//        maladies.put("X","obsessionnel-compulsif");
//        maladies.put("Y","trouble anxieux");
//        maladies.put("Z","hystérie");
        premises.add("AB");
        premises.add("C");
        premises.add("CD");
        premises.add("DEF");

    }


    public ArrayList<Character> enricherBF(ArrayList bf){
        boolean loop=true;
        while (loop==true){
            int x=chooseRule();
            x++;
//            System.out.println(x);
            switch (x){
                case 0:loop=false;
                        break;
                case 1:
                    if(!baseDesFaits.contains('F'))
                    bf.add('F');
                    premises.set(0,"");
                    break;
                case 2:
                    if(!baseDesFaits.contains('A'))
                    bf.add('A');
                    premises.set(1,"");
                    break;
                case 3:
                    if(!baseDesFaits.contains('B'))
                    bf.add('B');
                    premises.set(2,"");
                    break;
                case 4:
                    if(!baseDesFaits.contains('G'))
                    bf.add('G');
                    premises.set(3,"");
                    break;
            }
        }
        return bf;
    }
    public int chooseRule(){//we choose the rule that have more utilisable promises
        int maxi=-1;
        int max=0;
        for (int i = 0; i < premises.size(); i++) {
            String x= premises.get(i);
            if(!x.isEmpty()&&x.length()>max&&ruleApplicable(x)){
//                System.out.println("chooseRule "+x);
                max=x.length();
                maxi=i;
            }
        }
        return maxi;
    }
    public static String convertBF(ArrayList bf,int j){

        StringBuilder readableBF = new StringBuilder();
//        System.out.println("j "+j+" size "+bf.size());
        for (int i=j; i < bf.size(); i++) {
            System.out.println("animale "+clauses.get(bf.get(i)));
            readableBF.append("animale "+clauses.get(bf.get(i))+"\n");
        }
        System.out.println();
        return String.valueOf(readableBF);
    }

    public static String convertBF(ArrayList bf){
        clauses=getClauses();
        StringBuilder readableBF = new StringBuilder();
        for (int i=0; i < bf.size(); i++) {
            System.out.println("animale "+clauses.get(bf.get(i)));
            readableBF.append("animale "+clauses.get(bf.get(i))+"\n");

        }
        return String.valueOf(readableBF);
    }
    public static boolean ruleApplicable(String str){
        char[] c=str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if(!baseDesFaits.contains(c[i])){
                return false;
            }
        }
        return true;
    }
}
