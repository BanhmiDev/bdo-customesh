/*
 *  Copyright 2017 Son Nguyen <mail@gimu.org>
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package main.java.org.gimu.custommesh;

import java.util.HashMap;
import java.util.Map;

public class Constants {

    public static final DataBlock GAME_VERSION = new DataBlock(4, 12);
    public static final DataBlock CLASS_ID = new DataBlock(68, 8);

    public static final Map<Long, String> CLASS_MAP;
    static
    {
        CLASS_MAP = new HashMap<Long, String>();
        CLASS_MAP.put(Long.parseUnsignedLong("2142453751"), "Dark Knight");
        CLASS_MAP.put(Long.parseUnsignedLong("1474279357"), "Sorceress");
        CLASS_MAP.put(Long.parseUnsignedLong("18446744072574971903"), "Ninja");
        CLASS_MAP.put(Long.parseUnsignedLong("18446744073540722173"), "Musa");
        CLASS_MAP.put(Long.parseUnsignedLong("18446744072422947133"), "Maehwa");
        CLASS_MAP.put(Long.parseUnsignedLong("18446744073487244523"), "Kunoichi");
        CLASS_MAP.put(Long.parseUnsignedLong("18446744073036360565"), "Warrior");
        CLASS_MAP.put(Long.parseUnsignedLong("18446744073132025691"), "Valkyrie");
        CLASS_MAP.put(Long.parseUnsignedLong("18446744072350072758"), "Berserker");
        CLASS_MAP.put(Long.parseUnsignedLong("18446744073707320315"), "Tamer");
        CLASS_MAP.put(Long.parseUnsignedLong("18446744073441050229"), "Ranger");
        CLASS_MAP.put(Long.parseUnsignedLong("18446744072459124479"), "Witch");
        CLASS_MAP.put(Long.parseUnsignedLong("18446744073574790654"), "Wizard");
    }

    public static final Map<String, DataBlock> APPEARANCE_MAP;
    static
    {
        APPEARANCE_MAP = new HashMap<String, DataBlock>();

        APPEARANCE_MAP.put("HairAndFace", new DataBlock(76, 8));
        APPEARANCE_MAP.put("HairColors", new DataBlock(92, 8));
        APPEARANCE_MAP.put("Skin", new DataBlock(100, 8));
        APPEARANCE_MAP.put("EyeMakeup", new DataBlock(108, 24));
        APPEARANCE_MAP.put("EyeLine", new DataBlock(140, 8));
        APPEARANCE_MAP.put("Eyes", new DataBlock(148, 40));
        APPEARANCE_MAP.put("FaceShape", new DataBlock(220, 392));
        APPEARANCE_MAP.put("BodyShape", new DataBlock(604, 96));
        APPEARANCE_MAP.put("StandbyExpression", new DataBlock(884, 8));
        APPEARANCE_MAP.put("Voice", new DataBlock(892, 8));
    }
}
