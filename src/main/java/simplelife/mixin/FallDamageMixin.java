package simplelife.mixin;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import simplelife.common.item.LottBoots;

@Mixin(PlayerEntity.class)
public class FallDamageMixin {
    @Inject(at = @At("HEAD"), method = {"handleFallDamage(FF)Z"}, cancellable = true)
    public void handleFallDamageMixin(float fallDistance, float damageMultiplier, CallbackInfoReturnable<Boolean> cir) {
        PlayerEntity player = (PlayerEntity) (Object) this;
        ItemStack feetItems = player.getEquippedStack(EquipmentSlot.FEET);
        if (!feetItems.isEmpty()) {
            if (feetItems.getItem() instanceof LottBoots) {
                // Cancel the who falling-event.
                cir.cancel();
            }
        }
    }
}
