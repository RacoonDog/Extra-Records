package io.github.racoondog.extrarecords;

import io.github.racoondog.extrarecords.items.ModItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.random.Random;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOffers;

import java.util.LinkedList;
import java.util.List;

public class WanderingTraderOffers {
    static class SellItemFactory implements TradeOffers.Factory {
        private final ItemStack sell;
        private final int price;
        private final int count;
        private final int maxUses;
        private final int experience;
        private final float multiplier;

        public SellItemFactory(Item item, int price, int count, int maxUses, int experience) {
            this(new ItemStack(item), price, count, maxUses, experience, 0.05f);
        }

        public SellItemFactory(ItemStack stack, int price, int count, int maxUses, int experience, float multiplier) {
            this.sell = stack;
            this.price = price;
            this.count = count;
            this.maxUses = maxUses;
            this.experience = experience;
            this.multiplier = multiplier;
        }

        @Override
        public TradeOffer create(Entity entity, Random random) {
            return new TradeOffer(new ItemStack(Items.EMERALD, this.price), new ItemStack(this.sell.getItem(), this.count), this.maxUses, this.experience, this.multiplier);
        }
    }

    public static void registerOffers() {
        List<TradeOffers.Factory> trades = new LinkedList<>();

        trades.add(new SellItemFactory(ModItems.MUTATION, 5, 1, 8, 1));
        trades.add(new SellItemFactory(ModItems.MOOG_CITY_2, 5, 1, 8, 1));
        trades.add(new SellItemFactory(ModItems.BEGINNING_2, 5, 1, 8, 1));
        trades.add(new SellItemFactory(ModItems.FLOATING_TREES, 5, 1, 8, 1));

        TradeOfferHelper.registerWanderingTraderOffers(2, allTradesList -> allTradesList.addAll(
                trades
        ));
    }
}
