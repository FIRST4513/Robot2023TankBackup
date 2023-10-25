package frc.robot.arm;

public class armConfig {
    public static final double maxArmSpeed = 0.75;
    public static final boolean armMotorInvert = false;

    //   Enc Ct  | Enc º | Real º
    // ----------┼-------┼-------
    //  3969.0   |  250º |  100º  ⏎
    //     0.0   |    0º | -150º  ⏎
    //  1706.666 |  150º |    0º  ⏎
    //  2844.444 |  150º |  100º  ⏎

    public static final double encCountsPerDeg = (4096 / 360);
    public static final double encDegsPerCount = (360 / 4096);
    public static final double encCountOffset = (260 * encCountsPerDeg);

    public static final int armRetractLimit = 105;
    public static final int armExtendLimit = 15;

    public static final int armStowAngle = 90;
    public static final int armGroundAngle = 15;
    public static final int armStationAngle = 70;

    public static final double isAtTargetError = 1;
}
