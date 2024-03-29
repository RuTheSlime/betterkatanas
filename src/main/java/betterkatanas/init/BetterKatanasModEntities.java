
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package betterkatanas.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import betterkatanas.entity.YamiSukehiroEntity;
import betterkatanas.entity.YamiAdvitaSlashEntity;
import betterkatanas.entity.SoiFonEntity;
import betterkatanas.entity.SasukeUchihaEntity;
import betterkatanas.entity.RimuruTempestEntity;
import betterkatanas.entity.AkameBossEntity;

import betterkatanas.BetterKatanasMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BetterKatanasModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITIES, BetterKatanasMod.MODID);
	public static final RegistryObject<EntityType<AkameBossEntity>> AKAME_BOSS = register("akame_boss",
			EntityType.Builder.<AkameBossEntity>of(AkameBossEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(AkameBossEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<YamiSukehiroEntity>> YAMI_SUKEHIRO = register("yami_sukehiro",
			EntityType.Builder.<YamiSukehiroEntity>of(YamiSukehiroEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(YamiSukehiroEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<YamiAdvitaSlashEntity>> YAMI_ADVITA_SLASH = register("projectile_yami_advita_slash",
			EntityType.Builder.<YamiAdvitaSlashEntity>of(YamiAdvitaSlashEntity::new, MobCategory.MISC)
					.setCustomClientFactory(YamiAdvitaSlashEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<SasukeUchihaEntity>> SASUKE_UCHIHA = register("sasuke_uchiha",
			EntityType.Builder.<SasukeUchihaEntity>of(SasukeUchihaEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SasukeUchihaEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<RimuruTempestEntity>> RIMURU_TEMPEST = register("rimuru_tempest",
			EntityType.Builder.<RimuruTempestEntity>of(RimuruTempestEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(RimuruTempestEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<SoiFonEntity>> SOI_FON = register("soi_fon",
			EntityType.Builder.<SoiFonEntity>of(SoiFonEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(3).setCustomClientFactory(SoiFonEntity::new).fireImmune().sized(0.6f, 1.8f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			AkameBossEntity.init();
			YamiSukehiroEntity.init();
			SasukeUchihaEntity.init();
			RimuruTempestEntity.init();
			SoiFonEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(AKAME_BOSS.get(), AkameBossEntity.createAttributes().build());
		event.put(YAMI_SUKEHIRO.get(), YamiSukehiroEntity.createAttributes().build());
		event.put(SASUKE_UCHIHA.get(), SasukeUchihaEntity.createAttributes().build());
		event.put(RIMURU_TEMPEST.get(), RimuruTempestEntity.createAttributes().build());
		event.put(SOI_FON.get(), SoiFonEntity.createAttributes().build());
	}
}
