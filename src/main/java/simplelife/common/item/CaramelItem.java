package simplelife.common.item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

import java.util.List;

public class CaramelItem extends Item {
    public CaramelItem(Settings settings) {
        super(settings);
    }

    public static float saturationModifier = 0.2F;

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.simplelife.caramel_item.tooltip"));
    }

}
