package com.connor.module25;

public class Main {
    public static void main(String[] args) {
        String s = "And which of the gods was it that set them on to quarrel? It was the\n" +
                "son of Jove and Leto; for he was angry with the king and sent a pestilence\n" +
                "upon the host to plague the people, because the son of Atreus had\n" +
                "dishonoured Chryses his priest. Now Chryses had come to the ships\n" +
                "of the Achaeans to free his daughter, and had brought with him a great\n" +
                "ransom: moreover he bore in his hand the sceptre of Apollo wreathed\n" +
                "with a suppliant's wreath and he besought the Achaeans, but most of\n" +
                "all the two sons of Atreus, who were their chiefs. \n";
        String encrypted = "qdt mxysx ev jxu weti mqi yj jxqj iuj jxuc ed je gkqhhub? yj mqi jxu\n" +
                "ied ev zelu qdt buje; veh xu mqi qdwho myjx jxu aydw qdt iudj q fuijybudsu\n" +
                "kfed jxu xeij je fbqwku jxu fuefbu, rusqkiu jxu ied ev qjhuki xqt\n" +
                "tyixedekhut sxhoiui xyi fhyuij. dem sxhoiui xqt secu je jxu ixyfi\n" +
                "ev jxu qsxquqdi je vhuu xyi tqkwxjuh, qdt xqt rhekwxj myjx xyc q whuqj\n" +
                "hqdiec: cehueluh xu rehu yd xyi xqdt jxu isufjhu ev qfebbe mhuqjxut\n" +
                "myjx q ikffbyqdj'i mhuqjx qdt xu ruiekwxj jxu qsxquqdi, rkj ceij ev\n" +
                "qbb jxu jme iedi ev qjhuki, mxe muhu jxuyh sxyuvi. ";
        CaesarCipher cc = new CaesarCipher(s, 4124);
        s = cc.encrypt();
        System.out.println("Encrypted: " + s);

        cc.setMessage(cc.encrypt());
        s = cc.decrypt();
        System.out.println("Decrypted: " + s);

        s = cc.encrypt();
        System.out.println("Cracked: " + cc.crack(encrypted));

    }
}
