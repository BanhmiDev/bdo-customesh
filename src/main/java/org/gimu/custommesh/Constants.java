package main.java.org.gimu.custommesh;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Constants {

    public static final Map<BigInteger, String> CLASSMAP;
    static
    {
        CLASSMAP = new HashMap<BigInteger, String>();
        CLASSMAP.put(new BigInteger("9287506164331278002"), "Berserker");
        CLASSMAP.put(new BigInteger("17145927421228022900"), "Ranger");
        CLASSMAP.put(new BigInteger("10764718972524210919"), "Tamer");
        CLASSMAP.put(new BigInteger("1251758517271041305"), "Sorceress");
        CLASSMAP.put(new BigInteger("10777537339687380824"), "Valkyrie");
        CLASSMAP.put(new BigInteger("10764718972524210919"), "Witch");
        CLASSMAP.put(new BigInteger("17759858246325470518"), "Wizard");
        CLASSMAP.put(new BigInteger("4956354676860611428"), "Warrior");
        CLASSMAP.put(new BigInteger("7011772489808301336"), "Musa");
        CLASSMAP.put(new BigInteger("10613727790916565293"), "Maehwa");
        CLASSMAP.put(new BigInteger("17453010291577773289"), "Kunoichi");
        CLASSMAP.put(new BigInteger("10978699858950456037"), "Ninja");
        CLASSMAP.put(new BigInteger("7534873226274538481"), "Dark Knight");
    }
}
