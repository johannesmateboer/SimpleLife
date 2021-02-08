package simplelife.init;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.FoodComponent;

public class FoodComponentBuilder {

    /**
     * Default, simple Foodcomponent
     *
     * @return FoodComponent
     */
    public static FoodComponent getDefaultFoodComponent() {
        FoodComponent.Builder builder = new FoodComponent.Builder();
        return builder.hunger(2).snack().saturationModifier(0.5F).build();
    }

    /**
     * The saturation which the food-item provides
     *
     * @param saturation How much saturation it does
     * @return FoodComponent
     */
    public static FoodComponent getDefaultFoodComponent(float saturation) {
        FoodComponent.Builder builder = new FoodComponent.Builder();
        return builder.hunger(2).snack().saturationModifier(0.5F).build();
    }

    /**
     * The FoodComponent for the bleach
     *
     * @return FoodComponent
     */
    public static FoodComponent getBleachFoodComponent() {
        FoodComponent.Builder builder = new FoodComponent.Builder();
        return builder
                .hunger(-20)
                .alwaysEdible()
                .saturationModifier(2F)
                .build();
    }


}
