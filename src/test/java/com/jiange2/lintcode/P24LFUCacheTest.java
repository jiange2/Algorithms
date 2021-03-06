package com.jiange2.lintcode;

import com.jiange2.argorithms.lintcode.P24LFUCache;
import org.junit.Test;

public class P24LFUCacheTest {

    P24LFUCache cache = null;
    int[] r = {-1,-1,-1,-1,-1,280,-1,-1,261,-1,-1,-1,-1,-1,38,-1,-1,-1,148,-1,-1,-1,-1,-1,-1,-1,-1,136,-1,-1,-1,-1,-1,153,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,160,51,-1,218,-1,261,-1,-1,-1,193,-1,-1,220,-1,-1,-1,-1,306,219,-1,-1,266,193,90,-1,-1,147,-1,148,147,131,-1,291,291,-1,178,-1,136,-1,147,-1,287,-1,-1,-1,183,174,110,-1,-1,-1,12,-1,89,305,70,-1,94,-1,-1,241,176,220,-1,306,-1,183,-1,12,-1,95,-1,-1,311,111,190,84,-1,-1,177,157,-1,-1,174,51,183,-1,4,-1,-1,21,51,176,89,-1,-1,176,313,86,229,176,294,110,101,128,49,82,193,193,-1,85,101,126,66,-1,-1,-1,67,66,126,101,84,184,23,198,110,101,130,131,130,239,35,-1,287,-1,240,313,67,236,121,239,299,101,105,118,160,135,255,-1,11,101,258,-1,35,88,160,11,276,291,299,90,75,291,276,118,-1,121,252,145,191,-1,75,-1,23,139,-1,177,165,311,184,309,100,151,109,-1,90,136,299,173,173,-1,-1,313,45,252,-1,212,132,-1,137,308,15,-1,-1,288,-1,2,22,-1,299,137,295,139,13,101,-1,249,190,-1,136,-1,151,203,90,88,190,160,40,24,132,30,236,-1,67,119,-1,24,132,1,-1,236,236,-1,15,183,311,295,183,-1,188,47,311,53,256,144,268,44,188,233,1,191,275,-1,53,138,118,146,279,175,53,-1,305,44,250,132,88,111,301,102,-1,-1,301,-1,13,-1,215,-1,233,311,-1,230,76,188,-1,264,-1,-1,41,-1,24,-1,47,104,287,24,93,-1,295,69,-1,-1,48,-1,-1,41,283,287,-1,299,203,296,13,276,1,-1,98,240,250,133,-1,305,-1,175,55,266,-1,-1,157,116,71,-1,-1,283,3,-1,102,106,240,-1,286,50,101,299,301,-1,227,132,144,279,71,68,157,52,24,268,197,3,25,54,-1,271};
    int index = 0;

    @Test
    public void test(){
        cache = new P24LFUCache(1);
        set(2, 1);
        get(2);
        set(3, 2);
        get(2);
        get(3);
    }

    private void get(int key){
        /*int t = this.cache.get(key);
        if(t != r[index]){
            System.out.println(Arrays.toString(cache.queue));
            System.out.println(index+":"+key+":"+t + ":" + r[index]);
        }
        ++index;*/
        System.out.println(this.cache.get(key));
    }

    private void set(int key, int val){
        this.cache.set(key,val);
    }
}
