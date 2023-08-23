package dungeonfinder.dungeonfinder.mixin;

import dungeonfinder.dungeonfinder.DungeonFinder;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.DungeonFeature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(DungeonFeature.class)
public class DungeonFeatureMixin {
    @Inject(at = @At(value="INVOKE", target="Lnet/minecraft/world/gen/feature/util/FeatureContext;getOrigin()Lnet/minecraft/util/math/BlockPos;"), method = "generate(Lnet/minecraft/world/gen/feature/util/FeatureContext;)Z", locals = LocalCapture.CAPTURE_FAILHARD)
    private void generate(FeatureContext<DefaultFeatureConfig> context, CallbackInfoReturnable<Boolean> cir) {
        context.getWorld().setBlockState(context.getOrigin(), Blocks.END_ROD.getDefaultState(), 3);
        if (context.getOrigin().equals(new BlockPos(-368, 54, -169))) {
            DungeonFinder.LOGGER.info("TEST");
        }
    }
}
