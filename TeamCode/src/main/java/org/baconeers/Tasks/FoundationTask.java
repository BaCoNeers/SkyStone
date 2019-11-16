package org.baconeers.Tasks;

import org.baconeers.common.BaconOpMode;

import SkystoneDrive.SkystoneConfiguration;

public class FoundationTask extends BaseTask implements Task {

    private final SkystoneConfiguration config;
    private double FoundationPosition;

    public FoundationTask(BaconOpMode opMode, double time, SkystoneConfiguration config, double FoundationPosition) {
        super(opMode, time);
        this.config = config;
        this.FoundationPosition = FoundationPosition;

    }

    void update() {
         config.FoundationServo.setPosition(FoundationPosition);


    }

    @Override
    public void run() {
        if (isFinished()) {
            FoundationPosition = 0;
            update();
            return;
        }
        update();
    }

}