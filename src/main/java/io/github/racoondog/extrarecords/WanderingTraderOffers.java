package io.github.racoondog.extrarecords;

import io.github.racoondog.extrarecords.items.ModItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOffers;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class WanderingTraderOffers {
    private WanderingTraderOffers() {}

    public static TradeOffer create(ItemConvertible item, int price, int count, int maxUses, int experience) {
        return new TradeOffer(new ItemStack(Items.EMERALD, price), new ItemStack(item, count), maxUses, experience, 0.05F);
    }

    @Contract("null -> null; !null -> new")
    public static TradeOffer copy(TradeOffer tradeOffer) {
        if (tradeOffer == null)
            return null;
        return new TradeOffer(tradeOffer.toNbt());
    }

    public static TradeOffers.Factory asFactory(TradeOffer tradeOffer) {
        return new TradeOffers.Factory() {
            private final TradeOffer offer = copy(tradeOffer);

            @Nullable
            @Override
            public TradeOffer create(Entity entity, Random random) {
                return copy(offer);
            }
        };
    }

    public static void registerOffers() {
        List<TradeOffer> trades = new LinkedList<>();

        trades.add(create(ModItems.MUTATION, 5, 1, 8, 1));
        trades.add(create(ModItems.MOOG_CITY_2, 5, 1, 8, 1));
        trades.add(create(ModItems.BEGINNING_2, 5, 1, 8, 1));
        trades.add(create(ModItems.FLOATING_TREES, 5, 1, 8, 1));

        TradeOfferHelper.registerWanderingTraderOffers(2, allTradesList -> allTradesList.addAll(
                trades.stream().map(WanderingTraderOffers::asFactory).toList()
        ));
    }
}
