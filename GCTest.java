public class GCTest {
    public static void main(String[] args) {
        // 申请一块较大的内存
        // VM options: -XX:+PrintGCDetails  打印详细的垃圾回收（GC）信息
        // 使用Garbage-First（G1）垃圾收集器算法。
        //        [0.005s][info   ][gc,init] Heap Region Size: 2M
        //        [0.005s][info   ][gc,init] Heap Min Capacity: 8M
        //        [0.005s][info   ][gc,init] Heap Initial Capacity: 256M
        //        [0.005s][info   ][gc,init] Heap Max Capacity: 4G

        //元空间
        //        [0.009s][info   ][gc,metaspace] CDS archive(s) mapped at: [0x0000007000000000-0x0000007000be4000-0x0000007000be4000), size 12468224, SharedBaseAddress: 0x0000007000000000, ArchiveRelocationMode: 1.
        //        [0.009s][info   ][gc,metaspace] Compressed class space mapped at: 0x0000007001000000-0x0000007041000000, reserved size: 1073741824
        //        [0.009s][info   ][gc,metaspace] Narrow klass base: 0x0000007000000000, Narrow klass shift: 0, Narrow klass range: 0x100000000
        byte[] allocation1, allocation2;
        allocation1 = new byte[30900*1024];

        //          [0.046s][info   ][gc,heap,exit] Heap
        //          [0.046s][info   ][gc,heap,exit]  garbage-first heap   total 266240K, used 37735K [0x0000000700000000, 0x0000000800000000)
        //          [0.046s][info   ][gc,heap,exit]   region size 2048K, 2 young (4096K), 0 survivors (0K)
        //          [0.046s][info   ][gc,heap,exit]  Metaspace       used 484K, committed 640K, reserved 1114112K
        //          [0.046s][info   ][gc,heap,exit]   class space    used 28K, committed 128K, reserved 1048576K
        allocation2 = new byte[900*1024];

    }
}
