package ml.javalearn.back.app;

import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;
import java.util.Timer;
import java.util.TimerTask;

public class CPUUsage {

    public static void main(String[] args) throws Exception {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                getUsage();
            }
        };

        timer.schedule(timerTask, 100, 1000);
    }

    private void setTimer() {

    }

    private static void getUsage() {
        OperatingSystemMXBean operatingSystemMXBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        double result = operatingSystemMXBean.getProcessCpuLoad();
        System.out.println(result + " %");
    }

}
