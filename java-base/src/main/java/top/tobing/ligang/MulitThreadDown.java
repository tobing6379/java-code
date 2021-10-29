package top.tobing.ligang;

/**
 * @author tobing
 * @date 2021/9/25 12:33
 * @description 多线程下载
 */
public class MulitThreadDown {
    public static void main(String[] args) throws Exception {
        // 初始化DownUtil对象
        final DownUtil downUtil = new DownUtil("https://f74fb423c075dbc2467a154590ff37cf.dlied1.cdntips.net/dl.softmgr.qq.com/original/Development/jdk-8u191-windows-x64-8.0.1910.12.exe?mkey=614e8df9ab586db8&f=cfc4&cip=171.88.75.77&proto=https",
                "jdk-8u191-windows-x64-8.0.1910.12.exe", 8);
        // 开始下载
        downUtil.download();
        new Thread() {
            @Override
            public void run() {
                while (downUtil.getCompleteRate() < 1) {
                    // 每隔0.1秒查询一次任务的完成进度，
                    // GUI程序中可根据该进度来绘制进度条
                    System.out.println("已完成："
                            + downUtil.getCompleteRate());
                    try {
                        Thread.sleep(1000);
                    } catch (Exception ex) {
                    }
                }
            }
        }.start();
    }
}
