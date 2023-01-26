package com.noah.solo.domain.user.user.domain.common;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QProfile is a Querydsl query type for Profile
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QProfile extends BeanPath<Profile> {

    private static final long serialVersionUID = -383747748L;

    public static final QProfile profile = new QProfile("profile");

    public final DatePath<java.time.LocalDate> birthDate = createDate("birthDate", java.time.LocalDate.class);

    public final EnumPath<Profile.DeviceConnectionStatus> deviceConnectionStatus = createEnum("deviceConnectionStatus", Profile.DeviceConnectionStatus.class);

    public final EnumPath<Profile.Gender> gender = createEnum("gender", Profile.Gender.class);

    public final NumberPath<Double> height = createNumber("height", Double.class);

    public final StringPath nickname = createString("nickname");

    public final NumberPath<Double> weight = createNumber("weight", Double.class);

    public QProfile(String variable) {
        super(Profile.class, forVariable(variable));
    }

    public QProfile(Path<? extends Profile> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProfile(PathMetadata metadata) {
        super(Profile.class, metadata);
    }

}

