package com.lulan.shincolle.item;

import com.lulan.shincolle.capability.CapaShipInventory;
import com.lulan.shincolle.crafting.ShipCalc;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.entity.BasicEntityShipHostile;
import com.lulan.shincolle.entity.IShipMorph;
import com.lulan.shincolle.reference.unitclass.Attrs;
import com.lulan.shincolle.utility.EntityHelper;
import com.lulan.shincolle.utility.LogHelper;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShipSpawnEgg
        extends BasicItem {
    private static final String NAME = "shipspawnegg";
    private static final List<Integer> shipList = new ArrayList<>();

    public ShipSpawnEgg() {
        this.setUnlocalizedName(NAME);
        this.setRegistryName(NAME);
        this.setHasSubtypes(true);
        this.setMaxStackSize(1);
        this.initEggList();
    }

    @SideOnly(value=Side.CLIENT)
    public boolean hasEffect(ItemStack stack) {
        return stack.hasTagCompound();
    }

    @Override
    public int getTypes() {
        return shipList.size();
    }

    public int getIconTypes() {
        return 11;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        int metaid = itemstack.getItemDamage();
        switch (metaid) {
            case 0: {
                return "item.shincolle:smallegg";
            }
            case 1: {
                return "item.shincolle:largeegg";
            }
            default:
        }
        return String.format("item.shincolle:shipegg" + metaid);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void initModel() {
        ModelResourceLocation[] models = new ModelResourceLocation[this.getIconTypes()];
        for (int i = 0; i < this.getIconTypes(); ++i) {
            models[i] = new ModelResourceLocation(this.getRegistryName() + String.valueOf(i), "inventory");
        }
        ModelBakery.registerItemVariants(this, models);
        for (int i : shipList) {
            ModelLoader.setCustomModelResourceLocation(this, i, models[this.getIconFromDamage(i)]);
        }
    }

    public int getIconFromDamage(int meta) {
        switch (meta) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 38:
            case 53:
            case 54:
            case 55:
            case 56:
            case 2038:
            case 2053:
            case 2054:
            case 2055:
            case 2056: {
                return 2;
            }
            case 58:
            case 59:
            case 2058:
            case 2059: {
                return 3;
            }
            case 11:
            case 12:
            case 60:
            case 61:
            case 2060:
            case 2061: {
                return 4;
            }
            case 15:
            case 16:
            case 17:
            case 39:
            case 48:
            case 62:
            case 63:
            case 64:
            case 65:
            case 2039:
            case 2048:
            case 2062:
            case 2063:
            case 2064:
            case 2065: {
                return 5;
            }
            case 18: {
                return 6;
            }
            case 19:
            case 20:
            case 21:
            case 40:
            case 41:
            case 2040:
            case 2041: {
                return 7;
            }
            case 35: {
                return 8;
            }
            case 22:
            case 23:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 46:
            case 51:
            case 74: {
                return 9;
            }
            case 14:
            case 49:
            case 50:
            case 2049:
            case 2050: {
                return 10;
            }
            case 1: {
                return 1;
            }
            default:
        }
        return 0;
    }

    private void initEggList() {
        shipList.add(0);
        shipList.add(1);
        shipList.add(2);
        shipList.add(3);
        shipList.add(4);
        shipList.add(5);
        shipList.add(11);
        shipList.add(12);
        shipList.add(14);
        shipList.add(15);
        shipList.add(16);
        shipList.add(17);
        shipList.add(18);
        shipList.add(19);
        shipList.add(20);
        shipList.add(21);
        shipList.add(29);
        shipList.add(51);
        shipList.add(22);
        shipList.add(28);
        shipList.add(23);
        shipList.add(30);
        shipList.add(31);
        shipList.add(32);
        shipList.add(33);
        shipList.add(46);
        shipList.add(74);
        shipList.add(35);
        shipList.add(53);
        shipList.add(2053);
        shipList.add(54);
        shipList.add(2054);
        shipList.add(55);
        shipList.add(2055);
        shipList.add(56);
        shipList.add(2056);
        shipList.add(38);
        shipList.add(2038);
        shipList.add(58);
        shipList.add(2058);
        shipList.add(59);
        shipList.add(2059);
        shipList.add(61);
        shipList.add(2061);
        shipList.add(60);
        shipList.add(2060);
        shipList.add(49);
        shipList.add(2049);
        shipList.add(50);
        shipList.add(2050);
        shipList.add(62);
        shipList.add(2062);
        shipList.add(63);
        shipList.add(2063);
        shipList.add(64);
        shipList.add(2064);
        shipList.add(65);
        shipList.add(2065);
        shipList.add(39);
        shipList.add(2039);
        shipList.add(48);
        shipList.add(2048);
        shipList.add(40);
        shipList.add(2040);
        shipList.add(41);
        shipList.add(2041);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (tab != this.getCreativeTab()) return;
        for (int meta : shipList) {
            items.add(new ItemStack(this, 1, meta));
        }
    }

    private Entity getSpawnEntity(EntityPlayer player, ItemStack item, BlockPos pos, boolean checkPlayer) {
        if (!player.world.isRemote) {
            Entity ship = EntityHelper.createShipEntity(player.world, ShipCalc.rollShipType(item), null, pos.getX(), pos.getY(), pos.getZ(), false);
            if (ship != null) {
                if (ship instanceof BasicEntityShip && checkPlayer && EntityHelper.getPlayerUID(player) <= 0) {
                    ship.setDead();
                    return null;
                }
                return ship;
            }
            LogHelper.info("INFO: ShipSpawnEgg: entity spawn failed: classID: " + ShipCalc.rollShipType(item));
        }
        return null;
    }

    private void initEntityAttribute(ItemStack stack, EntityPlayer player, BasicEntityShip entity) {
        LogHelper.debug("DEBUG: init ship states");
        entity.setTamed(true);
        entity.setEntityTarget(null);
        if (stack.getItemDamage() > 1) {
            NBTTagCompound nbt = stack.getTagCompound();
            if (nbt != null) {
                String ownerid;
                CapaShipInventory capa = entity.getCapaShipInventory();
                if (nbt.hasKey("CpInv")) {
                    capa.deserializeNBT((NBTTagCompound)nbt.getTag("CpInv"));
                }
                int[] attrs = nbt.getIntArray("Attrs");
                int[] attrs2 = nbt.getIntArray("Attrs2");
                byte[] flags = nbt.getByteArray("Flags");
                try {
                    if (flags.length >= 16) {
                        entity.setStateFlag(1, flags[0] > 0);
                        entity.setStateFlag(3, flags[1] > 0);
                        entity.setStateFlag(4, flags[2] > 0);
                        entity.setStateFlag(5, flags[3] > 0);
                        entity.setStateFlag(6, flags[4] > 0);
                        entity.setStateFlag(7, flags[5] > 0);
                        entity.setStateFlag(9, flags[6] > 0);
                        entity.setStateFlag(12, flags[7] > 0);
                        entity.setStateFlag(18, flags[8] > 0);
                        entity.setStateFlag(19, flags[9] > 0);
                        entity.setStateFlag(20, flags[10] > 0);
                        entity.setStateFlag(21, flags[11] > 0);
                        entity.setStateFlag(22, flags[12] > 0);
                        entity.setStateFlag(23, flags[13] > 0);
                        entity.setStateFlag(25, flags[14] > 0);
                        entity.setStateFlag(26, flags[15] > 0);
                    }
                    if (attrs2.length >= 7) {
                        entity.setStateEmotion(0, attrs2[0], false);
                        entity.setStateMinor(10, attrs2[2]);
                        entity.setStateMinor(11, attrs2[3]);
                        entity.setStateMinor(12, attrs2[4]);
                        entity.setStateMinor(44, attrs2[5]);
                        entity.setStateMinor(9, attrs2[6]);
                    }
                    if (attrs.length >= 7) {
                        Attrs shipattrs = entity.getAttrs();
                        shipattrs.setAttrsBonus(0, attrs[1]);
                        shipattrs.setAttrsBonus(1, attrs[2]);
                        shipattrs.setAttrsBonus(2, attrs[3]);
                        shipattrs.setAttrsBonus(3, attrs[4]);
                        shipattrs.setAttrsBonus(4, attrs[5]);
                        shipattrs.setAttrsBonus(5, attrs[6]);
                        entity.setShipLevel(attrs[0], true);
                    }
                }
                catch (Exception e) {
                    LogHelper.info("EXCEPTION: init ship attrs fail: " + e);
                    e.printStackTrace();
                }
                String customname = nbt.getString("customname");
                if (!customname.isEmpty()) {
                    entity.setNameTag(customname);
                }
                int pid = nbt.getInteger("PlayerID");
                int sid = nbt.getInteger("ShipID");
                if (pid > 0) {
                    entity.setStateMinor(21, pid);
                }
                if (sid > 0) {
                    entity.setStateMinor(22, sid);
                }
                if ((ownerid = nbt.getString("owner")) != null && ownerid.length() > 5) {
                    entity.setOwnerId(UUID.fromString(ownerid));
                } else {
                    EntityHelper.setPetPlayerUUID(pid, entity);
                }
            } else {
                entity.setShipLevel(1, true);
                EntityHelper.setPetPlayerUUID(player.getUniqueID(), entity);
                EntityHelper.setPetPlayerUID(player, entity);
            }
        } else {
            LogHelper.debug("DEBUG: new spawn egg (random)");
            EntityHelper.setPetPlayerUUID(player.getUniqueID(), entity);
            EntityHelper.setPetPlayerUID(player, entity);
            entity.setShipLevel(1, true);
        }
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        if (worldIn.isRemote) {
            return new ActionResult<>(EnumActionResult.SUCCESS, stack);
        }
        RayTraceResult hitObj = this.rayTrace(worldIn, playerIn, true);
        if (hitObj.typeOfHit == RayTraceResult.Type.BLOCK) {
            IShipMorph ship;
            BlockPos hitPos = hitObj.getBlockPos();
            if (!worldIn.isBlockModifiable(playerIn, hitPos)) {
                return new ActionResult<>(EnumActionResult.PASS, stack);
            }

            if (!playerIn.canPlayerEdit(hitPos, hitObj.sideHit, stack)) {
                return new ActionResult<>(EnumActionResult.PASS, stack);
            }
            if (!playerIn.capabilities.isCreativeMode) {
                if (stack.getItemDamage() > 1 && stack.hasTagCompound()) {
                    NBTTagCompound nbt = stack.getTagCompound();
                    int costLevel = nbt.getIntArray("Attrs")[0] / 3;
                    if (playerIn.experienceLevel < costLevel) {
                        playerIn.sendMessage(new TextComponentTranslation("chat.shincolle:levelfail"));
                        return new ActionResult<>(EnumActionResult.FAIL, stack);
                    }
                    playerIn.addExperienceLevel(-costLevel);
                }
                stack.shrink(1);
            }
            if (stack.getItemDamage() > 2000) {
                ship = (BasicEntityShipHostile) this.getSpawnEntity(playerIn, stack, hitPos.up(), false);
                if (ship != null) {
                    ((BasicEntityShipHostile) ship).initAttrs(playerIn.getRNG().nextInt(4));
                    playerIn.world.spawnEntity((Entity) ship);
                    ((BasicEntityShipHostile) ship).playLivingSound();
                }
            } else {
                ship = (BasicEntityShip) this.getSpawnEntity(playerIn, stack, hitPos.up(), true);
                if (ship != null) {
                    playerIn.world.spawnEntity((Entity) ship);
                    ((BasicEntityShip) ship).playLivingSound();
                    this.initEntityAttribute(stack, playerIn, (BasicEntityShip) ship);
                    ((BasicEntityShip) ship).sendSyncPacketAll();
                }
            }
        }
        return new ActionResult<>(EnumActionResult.SUCCESS, stack);
    }
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        int[] material = new int[4];
        if (stack.hasTagCompound()) {
            NBTTagCompound nbt = stack.getTagCompound();
            if (nbt.hasKey("Attrs")) {
                EntityPlayer p2;
                tooltip.add(TextFormatting.AQUA + I18n.format("gui.shincolle:eggText") + " " + nbt.getIntArray("Attrs")[0] / 3);
                tooltip.add(TextFormatting.WHITE + nbt.getString("customname"));
                String ownername = nbt.getString("ownername");
                if (ownername.isEmpty() && (p2 = EntityHelper.getEntityPlayerByUIDAtClient(nbt.getInteger("PlayerID"))) != null) {
                    ownername = p2.getName();
                    nbt.setString("ownername", ownername);
                }
                tooltip.add(TextFormatting.RED + ownername);
            } else {
                material[0] = stack.getTagCompound().getInteger("Grudge");
                material[1] = stack.getTagCompound().getInteger("Abyssium");
                material[2] = stack.getTagCompound().getInteger("Ammo");
                material[3] = stack.getTagCompound().getInteger("Polymetal");
                tooltip.add(TextFormatting.WHITE + "" + material[0] + " " + I18n.format("item.shincolle:Grudge.name"));
                tooltip.add(TextFormatting.RED + "" + material[1] + " " + I18n.format("item.shincolle:ShipSpawnEgg.name"));
                tooltip.add(TextFormatting.GREEN + "" + material[2] + " " + I18n.format("item.shincolle:Ammo.name"));
                tooltip.add(TextFormatting.AQUA + "" + material[3] + " " + I18n.format("item.shincolle:ShipSpawnEgg1.name"));
            }
        }
    }
    }
