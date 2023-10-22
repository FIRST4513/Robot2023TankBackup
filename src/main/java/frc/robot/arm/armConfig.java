package frc.robot.arm;

public class armConfig {
    public static final double maxArmSpeed = 0.75;
    public static final boolean armMotorInvert = false;

    // 99 deg = 3969 ct
    // 11 deg = 2976 ct
    // 99 deg as ct should be 99 * 11.3... = 1126.4
    // actual 99 - should 99 = 3969 - 1126.4 = 2842.6
    // offset = 2842.6

    public static final double encCountOffset = 2842.6;
    public static final double encCountsPerDeg = 11.37777778;
    public static final double encDegsPerCount = 0.087890625;

    public static final int armRetractLimit = 110;
    public static final int armExtendLimit = 12;

    public static final int armStowAngle = 90;
    public static final int armGroundAngle = 15;
    public static final int armStationAngle = 70;
}
