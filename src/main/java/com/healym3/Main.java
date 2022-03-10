package com.healym3;

import com.healym3.breaker.Breaker;
import com.healym3.substitution.Key;
import com.healym3.substitution.Substitution;

public class Main {

    public static void main(String[] args) {
        Key key;
        key = new Key();
        key.setKey("defghijklmnopqrstuvwxyzabc");
        Substitution substitution = new Substitution(key);
        String cipher = substitution.encrypt("hello world this is mackenzie");
        String plain = substitution.decrypt(cipher);

        System.out.println(key);
        System.out.println(cipher);
        System.out.println(plain);
        Breaker breaker = new Breaker();
        breaker.breakCipher("msr crkqimurem xz jxukdmri bjvrejr qec renverriven mrjsextxna vb xer " +
                "xz msirr qjqcruvj crkqimuremb pvmsve msr jxttrnr xz bjvrejrb qec " +
                "mrjsextxna qm msr devoribvma xz sxdbmxe cxpemxpe. pr xzzri bmdcremb q " +
                "devwdr xkkximdevma mx qjsvror qjqcruvj bdjjrbb ve jxukdmri bjvrejr qec " +
                "renverriven mrjsextxna msixdns ivnxixdb qec ryjvmven jxdibrb, " +
                "vejtdcven decriniqcdqmr irbrqijs xkkximdevmvrb. pr qir jxuuvmmrc mx " +
                "miqveven bmdcremb zxi jsqttrenrb ve jxukdmri bjvrejr qec renverriven " +
                "mrjsextxna, qec ve zvrtcb irwdviven msr gexptrcnr qec bgvttb, xdi " +
                "jdiivjdtdu kixovcrb zxi bmdcremb pvmsve mryqb qec qixdec msr pxitc. " +
                "msr crkqimurem xz jxukdmri bjvrejrb qec renverriven mrjsextxna vb msr " +
                "zqbmrbm nixpven crkqimurem pvmsve msr jxttrnr xz bjvrejrb qec " +
                "mrjsextxna. qccvmvxeqtta, qb q bmdcrem xz msr jbrm crkqimurem, axd " +
                "pvtt nqve sqecb xe rykrivrejr qec kiqjmvjqt miqveven. bmdcremb pvtt fr " +
                "irwdvirc mx kqimvjvkqmr ve q brurbmri kixhrjm, psvjs pvtt miqve " +
                "bmdcremb mx pxig xe irqt vecdbmia kixftrub ve q mrqu reovixeurem msqm " +
                "msra pvtt rejxdemri pxigven ve vecdbmia qzmri niqcdqmvxe. msr brevxi " +
                "kixhrjm qttxpb bmdcremb mx qkkta msrvi jxdibr uqmrivqtb qec trqieven " +
                "rykrivrejrb mx brurbmri txen irqt pxitc kixhrjmb.");
    }
}
