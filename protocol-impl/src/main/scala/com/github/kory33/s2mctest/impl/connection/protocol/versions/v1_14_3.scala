package com.github.kory33.s2mctest.impl.connection.protocol.versions

import com.github.kory33.s2mctest.core.connection.codec.ByteCodec
import com.github.kory33.s2mctest.core.connection.protocol.{PacketIdBindings, Protocol}

object v1_14_3 {
  import com.github.kory33.s2mctest.impl.connection.packets.PacketIntent.Play.ClientBound.*
  import com.github.kory33.s2mctest.impl.connection.packets.PacketIntent.Play.ServerBound.*
  import com.github.kory33.s2mctest.impl.connection.packets.PacketIntent.Login.ClientBound.*
  import com.github.kory33.s2mctest.impl.connection.packets.PacketIntent.Login.ServerBound.*
  import com.github.kory33.s2mctest.impl.connection.codec.ByteCodecs.Common.given
  import com.github.kory33.s2mctest.impl.connection.codec.ByteCodecs.PositionCodec.given
  import com.github.kory33.s2mctest.impl.connection.codec.decode.macros.GenByteDecode.given

  // noinspection TypeAnnotation
  // format: off
  val playProtocol = Protocol(
    PacketIdBindings((
      0x00 -> ByteCodec.summonPair[TeleportConfirm],
      0x01 -> ByteCodec.summonPair[QueryBlockNBT],
      0x02 -> ByteCodec.summonPair[SetDifficulty],
      0x03 -> ByteCodec.summonPair[ChatMessage],
      0x04 -> ByteCodec.summonPair[ClientStatus],
      0x05 -> ByteCodec.summonPair[ClientSettings],
      0x06 -> ByteCodec.summonPair[TabComplete],
      0x07 -> ByteCodec.summonPair[ConfirmTransactionServerbound],
      0x08 -> ByteCodec.summonPair[ClickWindowButton],
      0x09 -> ByteCodec.summonPair[ClickWindow],
      0x0a -> ByteCodec.summonPair[CloseWindow],
      0x0b -> ByteCodec.summonPair[PluginMessageServerbound],
      0x0c -> ByteCodec.summonPair[EditBook],
      0x0d -> ByteCodec.summonPair[QueryEntityNBT],
      0x0e -> ByteCodec.summonPair[UseEntity_Hand],
      0x0f -> ByteCodec.summonPair[KeepAliveServerbound_i64],
      0x10 -> ByteCodec.summonPair[LockDifficulty],
      0x11 -> ByteCodec.summonPair[PlayerPosition],
      0x12 -> ByteCodec.summonPair[PlayerPositionLook],
      0x13 -> ByteCodec.summonPair[PlayerLook],
      0x14 -> ByteCodec.summonPair[Player],
      0x15 -> ByteCodec.summonPair[VehicleMove],
      0x16 -> ByteCodec.summonPair[SteerBoat],
      0x17 -> ByteCodec.summonPair[PickItem],
      0x18 -> ByteCodec.summonPair[CraftRecipeRequest],
      0x19 -> ByteCodec.summonPair[ClientAbilities_f32],
      0x1a -> ByteCodec.summonPair[PlayerDigging],
      0x1b -> ByteCodec.summonPair[PlayerAction],
      0x1c -> ByteCodec.summonPair[SteerVehicle],
      0x1d -> ByteCodec.summonPair[CraftingBookData],
      0x1e -> ByteCodec.summonPair[NameItem],
      0x1f -> ByteCodec.summonPair[ResourcePackStatus],
      0x20 -> ByteCodec.summonPair[AdvancementTab],
      0x21 -> ByteCodec.summonPair[SelectTrade],
      0x22 -> ByteCodec.summonPair[SetBeaconEffect],
      0x23 -> ByteCodec.summonPair[HeldItemChange],
      0x24 -> ByteCodec.summonPair[UpdateCommandBlock],
      0x25 -> ByteCodec.summonPair[UpdateCommandBlockMinecart],
      0x26 -> ByteCodec.summonPair[CreativeInventoryAction],
      0x27 -> ByteCodec.summonPair[UpdateJigsawBlock_Type],
      0x28 -> ByteCodec.summonPair[UpdateStructureBlock],
      0x29 -> ByteCodec.summonPair[SetSign],
      0x2a -> ByteCodec.summonPair[ArmSwing],
      0x2b -> ByteCodec.summonPair[SpectateTeleport],
      0x2c -> ByteCodec.summonPair[PlayerBlockPlacement_insideblock],
      0x2d -> ByteCodec.summonPair[UseItem],
    )),
    PacketIdBindings((
      0x00 -> ByteCodec.summonPair[SpawnObject_VarInt],
      0x01 -> ByteCodec.summonPair[SpawnExperienceOrb],
      0x02 -> ByteCodec.summonPair[SpawnGlobalEntity],
      0x03 -> ByteCodec.summonPair[SpawnMob_WithMeta],
      0x04 -> ByteCodec.summonPair[SpawnPainting_VarInt],
      0x05 -> ByteCodec.summonPair[SpawnPlayer_f64],
      0x06 -> ByteCodec.summonPair[Animation],
      0x07 -> ByteCodec.summonPair[Statistics],
      0x08 -> ByteCodec.summonPair[BlockBreakAnimation],
      0x09 -> ByteCodec.summonPair[UpdateBlockEntity],
      0x0a -> ByteCodec.summonPair[BlockAction],
      0x0b -> ByteCodec.summonPair[BlockChange_VarInt],
      0x0c -> ByteCodec.summonPair[BossBar],
      0x0d -> ByteCodec.summonPair[ServerDifficulty_Locked],
      0x0e -> ByteCodec.summonPair[ServerMessage_Position],
      0x0f -> ByteCodec.summonPair[MultiBlockChange_VarInt],
      0x10 -> ByteCodec.summonPair[TabCompleteReply],
      0x11 -> ByteCodec.summonPair[DeclareCommands],
      0x12 -> ByteCodec.summonPair[ConfirmTransaction],
      0x13 -> ByteCodec.summonPair[WindowClose],
      0x14 -> ByteCodec.summonPair[WindowItems],
      0x15 -> ByteCodec.summonPair[WindowProperty],
      0x16 -> ByteCodec.summonPair[WindowSetSlot],
      0x17 -> ByteCodec.summonPair[SetCooldown],
      0x18 -> ByteCodec.summonPair[PluginMessageClientbound],
      0x19 -> ByteCodec.summonPair[NamedSoundEffect],
      0x1a -> ByteCodec.summonPair[Disconnect],
      0x1b -> ByteCodec.summonPair[EntityAction],
      0x1c -> ByteCodec.summonPair[Explosion],
      0x1d -> ByteCodec.summonPair[ChunkUnload],
      0x1e -> ByteCodec.summonPair[ChangeGameState],
      0x1f -> ByteCodec.summonPair[WindowOpenHorse],
      0x20 -> ByteCodec.summonPair[KeepAliveClientbound_i64],
      0x21 -> ByteCodec.summonPair[ChunkData_HeightMap],
      0x22 -> ByteCodec.summonPair[Effect],
      0x23 -> ByteCodec.summonPair[Particle_Data],
      0x24 -> ByteCodec.summonPair[UpdateLight_NoTrust],
      0x25 -> ByteCodec.summonPair[JoinGame_i32_ViewDistance],
      0x26 -> ByteCodec.summonPair[Maps],
      0x27 -> ByteCodec.summonPair[TradeList_WithRestock],
      0x28 -> ByteCodec.summonPair[EntityMove_i16],
      0x29 -> ByteCodec.summonPair[EntityLookAndMove_i16],
      0x2a -> ByteCodec.summonPair[EntityLook_VarInt],
      0x2b -> ByteCodec.summonPair[Entity],
      0x2c -> ByteCodec.summonPair[VehicleTeleport],
      0x2d -> ByteCodec.summonPair[OpenBook],
      0x2e -> ByteCodec.summonPair[WindowOpen_VarInt],
      0x2f -> ByteCodec.summonPair[SignEditorOpen],
      0x30 -> ByteCodec.summonPair[CraftRecipeResponse],
      0x31 -> ByteCodec.summonPair[PlayerAbilities],
      0x32 -> ByteCodec.summonPair[CombatEvent],
      0x33 -> ByteCodec.summonPair[PlayerInfo],
      0x34 -> ByteCodec.summonPair[FacePlayer],
      0x35 -> ByteCodec.summonPair[TeleportPlayer_WithConfirm],
      0x36 -> ByteCodec.summonPair[UnlockRecipes_WithSmelting],
      0x37 -> ByteCodec.summonPair[EntityDestroy],
      0x38 -> ByteCodec.summonPair[EntityRemoveEffect],
      0x39 -> ByteCodec.summonPair[ResourcePackSend],
      0x3a -> ByteCodec.summonPair[Respawn_Gamemode],
      0x3b -> ByteCodec.summonPair[EntityHeadLook],
      0x3c -> ByteCodec.summonPair[SelectAdvancementTab],
      0x3d -> ByteCodec.summonPair[WorldBorder],
      0x3e -> ByteCodec.summonPair[Camera],
      0x3f -> ByteCodec.summonPair[SetCurrentHotbarSlot],
      0x40 -> ByteCodec.summonPair[UpdateViewPosition],
      0x41 -> ByteCodec.summonPair[UpdateViewDistance],
      0x42 -> ByteCodec.summonPair[ScoreboardDisplay],
      0x43 -> ByteCodec.summonPair[EntityMetadata],
      0x44 -> ByteCodec.summonPair[EntityAttach],
      0x45 -> ByteCodec.summonPair[EntityVelocity],
      0x46 -> ByteCodec.summonPair[EntityEquipment_VarInt],
      0x47 -> ByteCodec.summonPair[SetExperience],
      0x48 -> ByteCodec.summonPair[UpdateHealth],
      0x49 -> ByteCodec.summonPair[ScoreboardObjective],
      0x4a -> ByteCodec.summonPair[SetPassengers],
      0x4b -> ByteCodec.summonPair[Teams_VarInt],
      0x4c -> ByteCodec.summonPair[UpdateScore],
      0x4d -> ByteCodec.summonPair[SpawnPosition],
      0x4e -> ByteCodec.summonPair[TimeUpdate],
      0x4f -> ByteCodec.summonPair[Title],
      0x50 -> ByteCodec.summonPair[EntitySoundEffect],
      0x51 -> ByteCodec.summonPair[SoundEffect],
      0x52 -> ByteCodec.summonPair[StopSound],
      0x53 -> ByteCodec.summonPair[PlayerListHeaderFooter],
      0x54 -> ByteCodec.summonPair[NBTQueryResponse],
      0x55 -> ByteCodec.summonPair[CollectItem],
      0x56 -> ByteCodec.summonPair[EntityTeleport_f64],
      0x57 -> ByteCodec.summonPair[Advancements],
      0x58 -> ByteCodec.summonPair[EntityProperties],
      0x59 -> ByteCodec.summonPair[EntityEffect],
      0x5a -> ByteCodec.summonPair[DeclareRecipes],
      0x5b -> ByteCodec.summonPair[TagsWithEntities],
    ))
  )
  // format: on

  // noinspection TypeAnnotation
  // format: off
  val loginProtocol = Protocol(
    PacketIdBindings((
      0x00 -> ByteCodec.summonPair[LoginStart],
      0x01 -> ByteCodec.summonPair[EncryptionResponse],
      0x02 -> ByteCodec.summonPair[LoginPluginResponse],
    )),
    PacketIdBindings((
      0x00 -> ByteCodec.summonPair[LoginDisconnect],
      0x01 -> ByteCodec.summonPair[EncryptionRequest],
      0x02 -> ByteCodec.summonPair[LoginSuccess_String],
      0x03 -> ByteCodec.summonPair[SetInitialCompression],
      0x04 -> ByteCodec.summonPair[LoginPluginRequest],
    ))
  )
  // format: on
}
