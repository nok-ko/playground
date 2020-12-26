package me.nokko.playground.item

import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.ItemUsageContext
import net.minecraft.nbt.ByteTag
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.hit.HitResult
import net.minecraft.world.RaycastContext
import net.minecraft.world.World


class EnderLetterItem : Item(Settings()) {
    companion object {
        const val itemID: String = "ender_letter"
    }

    // TODO:
    // [x] unread property + NBT
    // [] sending
    // [] sender property + NBT (remember UUID, not username!)
    // [] itemStack property + NBT (?? some sort of Inventory implementation)

    override fun hasGlint(stack: ItemStack): Boolean {
        // Check for ender_letter[unread:true] tag
        if (stack.tag?.getBoolean("unread") == true)
            return true
        return super.hasGlint(stack)
    }

    override fun use(world: World, user: PlayerEntity, hand: Hand): TypedActionResult<ItemStack> {
        val itemStack = user.getStackInHand(hand)

        return if (!user.isSneaking){
            user.swingHand(hand) // Swing the hand before we open the inventory

            TypedActionResult.fail(itemStack)
        } else {
            TypedActionResult.success(itemStack, world.isClient())
        }
    }
}