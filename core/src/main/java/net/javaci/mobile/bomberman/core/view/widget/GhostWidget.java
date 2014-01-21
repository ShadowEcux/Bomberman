package net.javaci.mobile.bomberman.core.view.widget;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import net.javaci.mobile.bomberman.core.models.GhostModel;

public class GhostWidget extends Actor {

    private GhostModel ghostModel;
    private Animation walkAnimation;
    private Animation deadAnimation;

    private float elapsedTime;
    private TextureRegion currentFrame;

    public GhostWidget(TextureAtlas atlas, GhostModel model) {
        this.ghostModel = model;
        prepareWalkAnimation(atlas);
        prepareDeadAnimation(atlas);
    }

    private void prepareDeadAnimation(TextureAtlas atlas) {
        TextureRegion frames[] = new TextureRegion[3];
        frames[0] = atlas.findRegion(generateDeadImageName(ghostModel.getType().getValue(), 1));
        frames[1] = atlas.findRegion(generateDeadImageName(ghostModel.getType().getValue(), 2));
        frames[2] = atlas.findRegion(generateDeadImageName(ghostModel.getType().getValue(), 3));
        deadAnimation = new Animation(0.15f, frames);
    }

    private void prepareWalkAnimation(TextureAtlas atlas) {
        TextureRegion frames[] = new TextureRegion[3];
        frames[0] = atlas.findRegion(generateMoveImageName(ghostModel.getType().getValue(), 1));
        frames[1] = atlas.findRegion(generateMoveImageName(ghostModel.getType().getValue(), 2));
        frames[2] = atlas.findRegion(generateMoveImageName(ghostModel.getType().getValue(), 3));
        walkAnimation = new Animation(0.15f, frames);
    }

    private String generateMoveImageName(int type, int frameIndex) {
        return "ghost" + type + "move" + frameIndex;
    }

    private String generateDeadImageName(int type, int frameIndex) {
        return "ghost" + type + "dead" + frameIndex;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        float deltaTime = Gdx.graphics.getDeltaTime();
        elapsedTime += deltaTime;

        switch (ghostModel.getState()) {
            case WALKING:
                currentFrame = walkAnimation.getKeyFrame(elapsedTime, true);
                break;
            case DEAD:
                currentFrame = deadAnimation.getKeyFrame(elapsedTime, true);
                break;
            default:
                break;
        }

        batch.draw(currentFrame, ghostModel.getX(), ghostModel.getY(), currentFrame.getRegionWidth()*3, currentFrame.getRegionHeight()*3);
    }
}
