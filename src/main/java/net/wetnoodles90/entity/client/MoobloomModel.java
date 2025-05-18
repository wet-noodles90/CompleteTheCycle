package net.wetnoodles90.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.util.math.MathHelper;
import net.wetnoodles90.CompleteTheCycle;

import java.util.Optional;

public class MoobloomModel<MoobloomEntity extends EntityRenderState> extends EntityModel<MoobloomEntity> {

    public static EntityModelLayer MOOBLOOM = new EntityModelLayer(CompleteTheCycle.ofCTC("moobloom"), "main");

    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart leg1;
    private final ModelPart leg2;
    private final ModelPart leg3;
    private final ModelPart leg4;
    public MoobloomModel(ModelPart root) {
        super(root);
        this.head = root.getChild("head");
        this.body = root.getChild("body");
        this.leg1 = root.getChild("leg1");
        this.leg2 = root.getChild("leg2");
        this.leg3 = root.getChild("leg3");
        this.leg4 = root.getChild("leg4");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -4.0F, -6.0F, 8.0F, 8.0F, 6.0F, new Dilation(0.0F))
                .uv(22, 0).cuboid(4.0F, -5.0F, -5.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F))
                .uv(22, 0).cuboid(-5.0F, -5.0F, -5.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F))
                .uv(6, 10).cuboid(-3.0F, 1.0F, -7.0F, 6.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, 4.0F, -8.0F));

        ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(18, 4).cuboid(-6.0F, -10.0F, -7.0F, 12.0F, 18.0F, 10.0F, new Dilation(0.0F))
                .uv(0, 33).cuboid(-2.0F, 2.0F, -8.0F, 4.0F, 6.0F, 1.0F, new Dilation(0.0F))
                .uv(6, 32).cuboid(-5.0F, -5.0F, 3.0F, 10.0F, 0.0F, 10.0F, new Dilation(0.0F))
                .uv(6, 32).cuboid(-5.0F, 3.0F, 2.0F, 10.0F, 0.0F, 10.0F, new Dilation(0.0F))
                .uv(36, 23).cuboid(0.0F, -10.0F, 3.0F, 0.0F, 10.0F, 10.0F, new Dilation(0.0F))
                .uv(36, 23).cuboid(0.0F, -2.0F, 2.0F, 0.0F, 10.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 5.0F, 2.0F, 1.5708F, 0.0F, 0.0F));

        ModelPartData leg1 = modelPartData.addChild("leg1", ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.origin(-4.0F, 12.0F, 7.0F));

        ModelPartData leg2 = modelPartData.addChild("leg2", ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.origin(4.0F, 12.0F, 7.0F));

        ModelPartData leg3 = modelPartData.addChild("leg3", ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, 0.0F, -1.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.origin(-4.0F, 12.0F, -6.0F));

        ModelPartData leg4 = modelPartData.addChild("leg4", ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, 0.0F, -1.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.origin(4.0F, 12.0F, -6.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void setAngles(MoobloomEntity entity) {
        super.setAngles(entity);

        this.getBody().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(this.getHead().yaw, this.getHead().pitch);
    }

    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
    }

    public ModelPart getBody() {
        return body;
    }

    public ModelPart getHead() {
        return head;
    }

    public ModelPart getLeg1() {
        return leg1;
    }

    public ModelPart getLeg2() {
        return leg2;
    }

    public ModelPart getLeg3() {
        return leg3;
    }

    public ModelPart getLeg4() {
        return leg4;
    }

    @Override
    public Optional<ModelPart> getPart(String name) {
        return super.getPart("body");
    }
}
