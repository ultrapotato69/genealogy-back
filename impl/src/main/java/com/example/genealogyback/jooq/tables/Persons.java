/*
 * This file is generated by jOOQ.
 */
package com.example.genealogyback.jooq.tables;


import com.example.genealogyback.dto.GenderDto;
import com.example.genealogyback.jooq.Keys;
import com.example.genealogyback.jooq.Public;
import com.example.genealogyback.jooq.tables.Parents.ParentsPath;
import com.example.genealogyback.jooq.tables.Persons.PersonsPath;
import com.example.genealogyback.jooq.tables.records.PersonsRecord;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.InverseForeignKey;
import org.jooq.Name;
import org.jooq.Path;
import org.jooq.PlainSQL;
import org.jooq.QueryPart;
import org.jooq.Record;
import org.jooq.SQL;
import org.jooq.Schema;
import org.jooq.Select;
import org.jooq.Stringly;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.EnumConverter;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * Информация о людях.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class Persons extends TableImpl<PersonsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.persons</code>
     */
    public static final Persons PERSONS = new Persons();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PersonsRecord> getRecordType() {
        return PersonsRecord.class;
    }

    /**
     * The column <code>public.persons.id</code>. Идентификатор человека
     */
    public final TableField<PersonsRecord, UUID> ID = createField(DSL.name("id"), SQLDataType.UUID.nullable(false).defaultValue(DSL.field(DSL.raw("gen_random_uuid()"), SQLDataType.UUID)), this, "Идентификатор человека");

    /**
     * The column <code>public.persons.first_name</code>. Имя
     */
    public final TableField<PersonsRecord, String> FIRST_NAME = createField(DSL.name("first_name"), SQLDataType.CLOB.nullable(false), this, "Имя");

    /**
     * The column <code>public.persons.surname</code>.
     */
    public final TableField<PersonsRecord, String> SURNAME = createField(DSL.name("surname"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.persons.gender</code>. Пол
     */
    public final TableField<PersonsRecord, GenderDto> GENDER = createField(DSL.name("gender"), SQLDataType.VARCHAR(10).nullable(false), this, "Пол", new EnumConverter<String, GenderDto>(String.class, GenderDto.class));

    /**
     * The column <code>public.persons.birth_date</code>. Дата рождения
     */
    public final TableField<PersonsRecord, LocalDate> BIRTH_DATE = createField(DSL.name("birth_date"), SQLDataType.LOCALDATE, this, "Дата рождения");

    /**
     * The column <code>public.persons.spouse_id</code>. Идентификатор супруга
     */
    public final TableField<PersonsRecord, UUID> SPOUSE_ID = createField(DSL.name("spouse_id"), SQLDataType.UUID, this, "Идентификатор супруга");

    /**
     * The column <code>public.persons.maiden_name</code>. Девичья фамилия
     */
    public final TableField<PersonsRecord, String> MAIDEN_NAME = createField(DSL.name("maiden_name"), SQLDataType.CLOB, this, "Девичья фамилия");

    /**
     * The column <code>public.persons.death_date</code>. Дата смерти
     */
    public final TableField<PersonsRecord, LocalDate> DEATH_DATE = createField(DSL.name("death_date"), SQLDataType.LOCALDATE, this, "Дата смерти");

    /**
     * The column <code>public.persons.bio</code>. Биография
     */
    public final TableField<PersonsRecord, String> BIO = createField(DSL.name("bio"), SQLDataType.CLOB, this, "Биография");

    /**
     * The column <code>public.persons.avatar</code>. Ссылка на фотографию
     */
    public final TableField<PersonsRecord, String> AVATAR = createField(DSL.name("avatar"), SQLDataType.CLOB, this, "Ссылка на фотографию");

    /**
     * The column <code>public.persons.is_alive</code>. Флаг жив ли человек
     */
    public final TableField<PersonsRecord, Boolean> IS_ALIVE = createField(DSL.name("is_alive"), SQLDataType.BOOLEAN, this, "Флаг жив ли человек");

    private Persons(Name alias, Table<PersonsRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private Persons(Name alias, Table<PersonsRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment("Информация о людях."), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>public.persons</code> table reference
     */
    public Persons(String alias) {
        this(DSL.name(alias), PERSONS);
    }

    /**
     * Create an aliased <code>public.persons</code> table reference
     */
    public Persons(Name alias) {
        this(alias, PERSONS);
    }

    /**
     * Create a <code>public.persons</code> table reference
     */
    public Persons() {
        this(DSL.name("persons"), null);
    }

    public <O extends Record> Persons(Table<O> path, ForeignKey<O, PersonsRecord> childPath, InverseForeignKey<O, PersonsRecord> parentPath) {
        super(path, childPath, parentPath, PERSONS);
    }

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    public static class PersonsPath extends Persons implements Path<PersonsRecord> {
        public <O extends Record> PersonsPath(Table<O> path, ForeignKey<O, PersonsRecord> childPath, InverseForeignKey<O, PersonsRecord> parentPath) {
            super(path, childPath, parentPath);
        }
        private PersonsPath(Name alias, Table<PersonsRecord> aliased) {
            super(alias, aliased);
        }

        @Override
        public PersonsPath as(String alias) {
            return new PersonsPath(DSL.name(alias), this);
        }

        @Override
        public PersonsPath as(Name alias) {
            return new PersonsPath(alias, this);
        }

        @Override
        public PersonsPath as(Table<?> alias) {
            return new PersonsPath(alias.getQualifiedName(), this);
        }
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<PersonsRecord> getPrimaryKey() {
        return Keys.PK_PERSONS_UUID;
    }

    @Override
    public List<ForeignKey<PersonsRecord, ?>> getReferences() {
        return Arrays.asList(Keys.PERSONS__FK_SPOUSE_ID_PERSON_ID);
    }

    private transient PersonsPath _persons;

    /**
     * Get the implicit join path to the <code>public.persons</code> table.
     */
    public PersonsPath persons() {
        if (_persons == null)
            _persons = new PersonsPath(this, Keys.PERSONS__FK_SPOUSE_ID_PERSON_ID, null);

        return _persons;
    }

    private transient ParentsPath _parentsChildIdFk;

    /**
     * Get the implicit to-many join path to the <code>public.parents</code>
     * table, via the <code>parents_child_id_fk</code> key
     */
    public ParentsPath parentsChildIdFk() {
        if (_parentsChildIdFk == null)
            _parentsChildIdFk = new ParentsPath(this, null, Keys.PARENTS__PARENTS_CHILD_ID_FK.getInverseKey());

        return _parentsChildIdFk;
    }

    private transient ParentsPath _parentsParentIdFk;

    /**
     * Get the implicit to-many join path to the <code>public.parents</code>
     * table, via the <code>parents_parent_id_fk</code> key
     */
    public ParentsPath parentsParentIdFk() {
        if (_parentsParentIdFk == null)
            _parentsParentIdFk = new ParentsPath(this, null, Keys.PARENTS__PARENTS_PARENT_ID_FK.getInverseKey());

        return _parentsParentIdFk;
    }

    @Override
    public Persons as(String alias) {
        return new Persons(DSL.name(alias), this);
    }

    @Override
    public Persons as(Name alias) {
        return new Persons(alias, this);
    }

    @Override
    public Persons as(Table<?> alias) {
        return new Persons(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Persons rename(String name) {
        return new Persons(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Persons rename(Name name) {
        return new Persons(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Persons rename(Table<?> name) {
        return new Persons(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Persons where(Condition condition) {
        return new Persons(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Persons where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Persons where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Persons where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Persons where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Persons where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Persons where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Persons where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Persons whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Persons whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
