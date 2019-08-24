package designPatterns.builder;

/**
 * @AUTHOR PizAn
 * @CREAET 2019-08-24 13:39
 */

public class Main {
    public static void main(String[] args) {
        //想要哪个属性就往后加
        BuilderPat pat = new BuilderPat.Builder(345, 99).calories(2).carbohydrate(3)
                .fat(3).sodium(23).build();
        System.out.println(pat);
    }
}
