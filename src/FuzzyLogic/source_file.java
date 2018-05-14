package FuzzyLogic;

import java.io.*;
import java.util.*;

/**
 * @author akash
 */
public class source_file {
    static float[][] a1;
    static TreeMap<Integer, Integer> fd = new TreeMap<>();
    static int FtotalWords = 0, TPosting = 0, SPosting = 1, LPosting = 0;

    public static void main(String[] args) throws IOException, FileNotFoundException, IndexOutOfBoundsException {


        core_work obj1 = new core_work();

        String cran = "input/cran.txt";

        obj1.form_inverted_index(cran);

        obj1.calculate_term_frequency();


        Scanner in = new Scanner(System.in);
        String query;// = "!!(experimental)";
        System.out.println("enter query like ('&&'for AND) , ('||'for 'OR') , ('!!'for NOT) for exapmle &&(experimental,rotational)");
        query = in.next();//enter query here
        System.out.println(query);
        obj1.process_query(query);
    }
}
