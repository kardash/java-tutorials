package com.addressbook.entities;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QPerson is a Querydsl query type for Person
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPerson extends EntityPathBase<Person> {

    private static final long serialVersionUID = -672099260L;

    public static final QPerson person = new QPerson("person");

    public final QAbstractEntity _super = new QAbstractEntity(this);

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final StringPath birthdate = createString("birthdate");

    public final ListPath<Contact, QContact> contacts = this.<Contact, QContact>createList("contacts", Contact.class, QContact.class, PathInits.DIRECT2);

    public final StringPath firstname = createString("firstname");

    public final EnumPath<Gender> gender = createEnum("gender", Gender.class);

    //inherited
    public final StringPath id = _super.id;

    public final StringPath lastname = createString("lastname");

    public final StringPath middlename = createString("middlename");

    public final StringPath prefix = createString("prefix");

    public final StringPath suffix = createString("suffix");

    public QPerson(String variable) {
        super(Person.class, forVariable(variable));
    }

    public QPerson(Path<? extends Person> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPerson(PathMetadata<?> metadata) {
        super(Person.class, metadata);
    }

}

