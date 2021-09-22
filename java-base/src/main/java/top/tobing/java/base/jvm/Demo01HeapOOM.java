package top.tobing.java.base.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tobing
 * @date 2021/9/22 17:08
 * @description Heap OOM 排错
 * @VM_Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * Java堆内存溢出异常测试
 * 1）设置jvm参数「-XX： +HeapDumpOnOutOf-MemoryError」，让虚拟机出现内存泄漏是Dump出当前内存堆转储快照以便于分析
 * 2）对于堆出现OOM，可能有需要对Dump出来的堆转快照进行分析
 * 2.1）确认内存中导致OOM的对象是否为必要的，即分清楚是「内存泄漏」还是「内存溢出」
 * 2.2）如果是内存泄漏，使用工具「Eclipse Memory Analyzer」查看对象到GC Roots的引用链，找到泄漏对象通过上面路径，与那些GC Roots关联；
 * 2.3）如果不是内存溢出，表明对象确实必须存活，这时可以检测Java虚拟机的堆参数设置与机器的内存对比，查看是否有上调空间，再从代码层面检测是否存在某些对象生命周期过长，持有时间过长、储存结构设计不合理等情况，尽量减少程序运行期内存消耗；
 *
 */
public class Demo01HeapOOM {


    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }

}
