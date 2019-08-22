package ml.javalearn.back.app;

import com.sun.management.OperatingSystemMXBean;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;

import java.lang.management.ManagementFactory;

public class RAMUsage extends Parent {

    private long totalRAM;
    private long freeRAM;
    private double totalResult;
    private double busyResult;
    private double usageRamInPercent;
    private String result;

    public String getInfoRam() {
        OperatingSystemMXBean mxBean1 = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

        totalRAM = mxBean1.getTotalPhysicalMemorySize();
        freeRAM  = mxBean1.getFreePhysicalMemorySize();
        usageRamInPercent = (double) (totalRAM - freeRAM) / totalRAM;
        usageRamInPercent = Math.round(usageRamInPercent * 100.0);

        totalResult = (double) Math.round((mxBean1.getTotalPhysicalMemorySize() * 1.0 /1024/1024/1024) * 100) / 100;
        busyResult  = (double) Math.round(((mxBean1.getTotalPhysicalMemorySize() - mxBean1.getFreePhysicalMemorySize())
                * 1.0/1024/1024/1024) * 100) / 100;

        return result = "RAM USAGE: " + busyResult + " Gb's / " + totalResult + " Gb's is busy (" + usageRamInPercent + " %)";
    }

}
