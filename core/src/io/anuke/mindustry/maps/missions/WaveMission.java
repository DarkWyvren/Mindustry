package io.anuke.mindustry.maps.missions;

import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.utils.Array;
import io.anuke.mindustry.game.GameMode;
import io.anuke.mindustry.game.SpawnGroup;
import io.anuke.mindustry.game.Team;
import io.anuke.mindustry.game.Waves;
import io.anuke.mindustry.maps.Sector;
import io.anuke.mindustry.maps.generation.Generation;
import io.anuke.ucore.util.Bundles;

import static io.anuke.mindustry.Vars.state;

public class WaveMission extends Mission{
    private final int target;

    public WaveMission(int target){
        this.target = target;
    }

    @Override
    public Array<SpawnGroup> getWaves(Sector sector){
        return Waves.getSpawns();
    }

    @Override
    public void generate(Generation gen){
        int coreX = gen.width/2, coreY = gen.height/2;
        generateCoreAt(gen, coreX, coreY, Team.blue);
    }

    @Override
    public GameMode getMode(){
        return GameMode.waves;
    }

    @Override
    public String displayString(){
        return Bundles.format("text.mission.wave", state.wave, target, (int)(state.wavetime/60));
    }

    @Override
    public String menuDisplayString(){
        return Bundles.format("text.mission.wave.menu", target);
    }

    @Override
    public boolean isComplete(){
        return state.wave >= target;
    }

    @Override
    public Array<GridPoint2> getSpawnPoints(Generation gen){
        return Array.with(new GridPoint2(gen.width/2, gen.height/2));
    }
}
