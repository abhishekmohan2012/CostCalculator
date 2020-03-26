package com.engine.cycle;

public interface Constants {

    //Named Query
    static final String CHAIN_ASSEMBLY = "ChainAssembly.findByType";
    static final String FRAME = "Frame.findByType";
    static final String SEAT = "Seat.findByType";
    static final String WHEEL = "Wheel.findByType";
    static final String RIM = "Rim.findByType";
    static final String SPOKE = "Spoke.findByType";
    static final String TUBE = "Tube.findByType";
    static final String TYRE = "Tyre.findByType";

    //Wheels
    static final String WHEEL_REGULAR = "REGULAR";
    static final String WHEEL_HIGH_STRENGTH = "HIGH-STRENGTH";

    //Chain Assembly
    static final String CHAIN_ASSEMBLY_ONE_SPEED = "ONE-SPEED";
    static final String CHAIN_ASSEMBLY_DERAILLEUR = "DERAILLEUR";

    //Frame
    static final String FRAME_DIAMOND = "DIAMOND";
    static final String FRAME_CROSS = "CROSS";

    //Seat
    static final String SEAT_WIDE = "WIDE";
    static final String SEAT_THIN = "THIN";

    //Rim
    static final String RIM_14 = "14-INCH";
    static final String RIM_20 = "20-INCH";

    //Spoke
    static final String SPOKE_MULTI_SPOKE = "MULTI-SPOKE";
    static final String SPOKE_TRI_SPOKE= "TRI-SPOKE";

    //Tube
    static final String TUBE_TUBELESS = "TUBELESS";
    static final String TUBE_TUBE = "TUBE";

    //Tyre
    static final String TYRE_WIDE = "WIDE";
    static final String TYRE_THIN = "THIN";

}
