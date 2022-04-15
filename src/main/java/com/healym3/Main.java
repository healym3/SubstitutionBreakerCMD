package com.healym3;

import com.healym3.breaker.Breaker;
import com.healym3.substitution.SubstitutionKey;
import com.healym3.substitution.Substitution;

public class Main {

    public static void main(String[] args) {
        SubstitutionKey key;
        key = new SubstitutionKey();
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

        breaker.breakCipher("Zn nabomrct wbtn, Tbewvc Ovmorvkvon cvvw ebmn bu vivoxrnv. " +
                "Msvh’ov z szow-jbofrct yovvw. Tbewvc Ovmorvkvon zov lnvw ubo vkvohmsrct uobd slcmrct zcw mozxfrct mb ovnxlv zcw " +
                "nvokrxv wbt jbof. Wvnarmv mszm aezhule, nbdvmrdvn tbbuh wvdvzcbo, msvh evzoc plrxfeh zcw xzc dznmvo z dlemrmlwv bu nfreen, rcxelwrct sbj mb avoubod zn nvzoxs zcw " +
                "ovnxlv wbtn zm msv nrmv bu z wrnznmvo. Tbewvc Ovmorvkvon dzfv mba-cbmxs msvozah wbtn. Tbewvcn zov bumvc vdaebhvw zn msvozah wbtn mb nbbmsv zcw xzed avbaev. " +
                "Tbewvcn nvvd mb szkv ovnvokvn bu vdazmsh zcw lcxbcwrmrbcze ebkv. Msvov’n qlnm nbdvmsrct zyblm z Tbewvc mszm xzc xzed zcw xbdubom zchbcv, " +
                //"uobd hblct xsrewovc mb vewvoeh azmrvcmn. Aznm alaahsbbw, Tbewvc Ovmorvkvon bumvc nmzh hblct zm svzom. Hbl fcbj zee mszm vilyvozcm " +
                //"alaah yvszkrbo? Mszm mvcwn mb eznm ebctvo rc Tbewvc Ovmorvkvon mszc bmsvo yovvwn. " +
                "Msvh dzmlov nebjeh zcw xzc yv aezhule " +
                "zcw wbjcortsm nreeh rcmb zwlemsbbw.");
    }
}
