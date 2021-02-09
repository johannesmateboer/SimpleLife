package simplelife.common.item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;
import simplelife.common.SimpleLife;
import java.util.List;

import static simplelife.common.SimpleLife.LottArmorMaterial;

public class LottBoots extends ArmorItem {

    public LottBoots() {
        super(LottArmorMaterial, EquipmentSlot.FEET, new Item.Settings().group(SimpleLife.ITEM_GROUP));
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.simplelife.lott_boots.tooltip"));
    }
}
