package com.runesuite.client.updater.mapper.std.classes

import org.kxtra.lang.list.startsWith
import com.runesuite.mapper.IdentityMapper
import com.runesuite.mapper.OrderMapper
import com.runesuite.mapper.annotations.DependsOn
import com.runesuite.mapper.annotations.MethodParameters
import com.runesuite.mapper.extensions.and
import com.runesuite.mapper.extensions.predicateOf
import com.runesuite.mapper.extensions.type
import com.runesuite.mapper.tree.Class2
import com.runesuite.mapper.tree.Field2
import com.runesuite.mapper.tree.Instruction2
import com.runesuite.mapper.tree.Method2
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.Type.*

@DependsOn(DualNode::class)
class ItemDefinition : IdentityMapper.Class() {
    override val predicate = predicateOf<Class2> { it.superType == type<DualNode>() }
            .and { it.instanceFields.count { it.type == ShortArray::class.type } == 4 }
            .and { it.instanceFields.count { it.type == Array<String>::class.type } == 2 }

    @MethodParameters("quantity")
    @DependsOn(Model::class)
    class getModel : InstanceMethod() {
        override val predicate = predicateOf<Method2> { it.returnType == type<Model>() }
    }

    class name : InstanceField() {
        override val predicate = predicateOf<Field2> { it.type == String::class.type }
    }

    class groundActions : OrderMapper.InConstructor.Field(ItemDefinition::class, 0) {
        override val predicate = predicateOf<Instruction2> { it.isField && it.fieldType == Array<String>::class.type }
    }

    class inventoryActions : OrderMapper.InConstructor.Field(ItemDefinition::class, 1) {
        override val predicate = predicateOf<Instruction2> { it.isField && it.fieldType == Array<String>::class.type }
    }

    class isMembersOnly : OrderMapper.InConstructor.Field(ItemDefinition::class, 0, 2) {
        override val predicate = predicateOf<Instruction2> { it.isField && it.fieldType == BOOLEAN_TYPE }
    }

    class isTradable : OrderMapper.InConstructor.Field(ItemDefinition::class, 1, 2) {
        override val predicate = predicateOf<Instruction2> { it.isField && it.fieldType == BOOLEAN_TYPE }
    }

    @DependsOn(Buffer::class)
    class read : IdentityMapper.InstanceMethod() {
        override val predicate = predicateOf<Method2> { it.returnType == VOID_TYPE }
                .and { it.arguments.startsWith(type<Buffer>()) }
                .and { it.instructions.none { it.opcode == BIPUSH && it.intOperand == 16 } }
    }

    @DependsOn(Buffer::class)
    class readNext : IdentityMapper.InstanceMethod() {
        override val predicate = predicateOf<Method2> { it.returnType == VOID_TYPE }
                .and { it.arguments.startsWith(type<Buffer>()) }
                .and { it.instructions.any { it.opcode == BIPUSH && it.intOperand == 16 } }
    }

    @DependsOn(Client.getItemDefinition::class)
    class id : OrderMapper.InMethod.Field(Client.getItemDefinition::class, 0) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == INT_TYPE && it.fieldOwner == type<ItemDefinition>() }
    }

    class zoom2d : OrderMapper.InConstructor.Field(ItemDefinition::class, 0) {
        override val predicate = predicateOf<Instruction2> { it.isField && it.fieldType == INT_TYPE }
    }

    class xan2d : OrderMapper.InConstructor.Field(ItemDefinition::class, 1) {
        override val predicate = predicateOf<Instruction2> { it.isField && it.fieldType == INT_TYPE }
    }

    class yan2d : OrderMapper.InConstructor.Field(ItemDefinition::class, 2) {
        override val predicate = predicateOf<Instruction2> { it.isField && it.fieldType == INT_TYPE }
    }

    class zan2d : OrderMapper.InConstructor.Field(ItemDefinition::class, 3) {
        override val predicate = predicateOf<Instruction2> { it.isField && it.fieldType == INT_TYPE }
    }

    class offsetX2d : OrderMapper.InConstructor.Field(ItemDefinition::class, 4) {
        override val predicate = predicateOf<Instruction2> { it.isField && it.fieldType == INT_TYPE }
    }

    class offsetY2d : OrderMapper.InConstructor.Field(ItemDefinition::class, 5) {
        override val predicate = predicateOf<Instruction2> { it.isField && it.fieldType == INT_TYPE }
    }

    class isStackable : OrderMapper.InConstructor.Field(ItemDefinition::class, 6) {
        override val predicate = predicateOf<Instruction2> { it.isField && it.fieldType == INT_TYPE }
    }

    class price : OrderMapper.InConstructor.Field(ItemDefinition::class, 7) {
        override val predicate = predicateOf<Instruction2> { it.isField && it.fieldType == INT_TYPE }
    }

    class team : OrderMapper.InConstructor.Field(ItemDefinition::class, 8) {
        override val predicate = predicateOf<Instruction2> { it.isField && it.fieldType == INT_TYPE }
    }

    class maleModel : OrderMapper.InConstructor.Field(ItemDefinition::class, 9) {
        override val predicate = predicateOf<Instruction2> { it.isField && it.fieldType == INT_TYPE }
    }

    class maleModel1 : OrderMapper.InConstructor.Field(ItemDefinition::class, 10) {
        override val predicate = predicateOf<Instruction2> { it.isField && it.fieldType == INT_TYPE }
    }

    class maleOffset : OrderMapper.InConstructor.Field(ItemDefinition::class, 11) {
        override val predicate = predicateOf<Instruction2> { it.isField && it.fieldType == INT_TYPE }
    }

    class femaleModel : OrderMapper.InConstructor.Field(ItemDefinition::class, 12) {
        override val predicate = predicateOf<Instruction2> { it.isField && it.fieldType == INT_TYPE }
    }

    class femaleModel1 : OrderMapper.InConstructor.Field(ItemDefinition::class, 13) {
        override val predicate = predicateOf<Instruction2> { it.isField && it.fieldType == INT_TYPE }
    }

    class femaleOffset : OrderMapper.InConstructor.Field(ItemDefinition::class, 14) {
        override val predicate = predicateOf<Instruction2> { it.isField && it.fieldType == INT_TYPE }
    }

    class maleModel2 : OrderMapper.InConstructor.Field(ItemDefinition::class, 15) {
        override val predicate = predicateOf<Instruction2> { it.isField && it.fieldType == INT_TYPE }
    }

    class femaleModel2 : OrderMapper.InConstructor.Field(ItemDefinition::class, 16) {
        override val predicate = predicateOf<Instruction2> { it.isField && it.fieldType == INT_TYPE }
    }

    class maleHeadModel : OrderMapper.InConstructor.Field(ItemDefinition::class, 17) {
        override val predicate = predicateOf<Instruction2> { it.isField && it.fieldType == INT_TYPE }
    }

    class maleHeadModel2 : OrderMapper.InConstructor.Field(ItemDefinition::class, 18) {
        override val predicate = predicateOf<Instruction2> { it.isField && it.fieldType == INT_TYPE }
    }

    class femaleHeadModel : OrderMapper.InConstructor.Field(ItemDefinition::class, 19) {
        override val predicate = predicateOf<Instruction2> { it.isField && it.fieldType == INT_TYPE }
    }

    class femaleHeadModel2 : OrderMapper.InConstructor.Field(ItemDefinition::class, 20) {
        override val predicate = predicateOf<Instruction2> { it.isField && it.fieldType == INT_TYPE }
    }

    class note : OrderMapper.InConstructor.Field(ItemDefinition::class, 21) {
        override val predicate = predicateOf<Instruction2> { it.isField && it.fieldType == INT_TYPE }
    }

    class notedTemplate : OrderMapper.InConstructor.Field(ItemDefinition::class, 22) {
        override val predicate = predicateOf<Instruction2> { it.isField && it.fieldType == INT_TYPE }
    }

    class resizeX : OrderMapper.InConstructor.Field(ItemDefinition::class, 23) {
        override val predicate = predicateOf<Instruction2> { it.isField && it.fieldType == INT_TYPE }
    }

    class resizeY : OrderMapper.InConstructor.Field(ItemDefinition::class, 24) {
        override val predicate = predicateOf<Instruction2> { it.isField && it.fieldType == INT_TYPE }
    }

    class resizeZ : OrderMapper.InConstructor.Field(ItemDefinition::class, 25) {
        override val predicate = predicateOf<Instruction2> { it.isField && it.fieldType == INT_TYPE }
    }

    class ambient : OrderMapper.InConstructor.Field(ItemDefinition::class, 26) {
        override val predicate = predicateOf<Instruction2> { it.isField && it.fieldType == INT_TYPE }
    }

    class contrast : OrderMapper.InConstructor.Field(ItemDefinition::class, 27) {
        override val predicate = predicateOf<Instruction2> { it.isField && it.fieldType == INT_TYPE }
    }

    class int1 : OrderMapper.InConstructor.Field(ItemDefinition::class, 28) {
        override val predicate = predicateOf<Instruction2> { it.isField && it.fieldType == INT_TYPE }
    }

    class unnotedId : OrderMapper.InConstructor.Field(ItemDefinition::class, 29) {
        override val predicate = predicateOf<Instruction2> { it.isField && it.fieldType == INT_TYPE }
    }

    class notedId : OrderMapper.InConstructor.Field(ItemDefinition::class, 30) {
        override val predicate = predicateOf<Instruction2> { it.isField && it.fieldType == INT_TYPE }
    }

    class int2 : OrderMapper.InConstructor.Field(ItemDefinition::class, 31) {
        override val predicate = predicateOf<Instruction2> { it.isField && it.fieldType == INT_TYPE }
    }

    class int3 : OrderMapper.InConstructor.Field(ItemDefinition::class, 32) {
        override val predicate = predicateOf<Instruction2> { it.isField && it.fieldType == INT_TYPE }
    }
}