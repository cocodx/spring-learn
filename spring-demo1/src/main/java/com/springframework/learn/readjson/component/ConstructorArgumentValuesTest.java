package com.springframework.learn.readjson.component;

import org.springframework.beans.BeanMetadataElement;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.lang.Nullable;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 正能量导师
 * @version 1.0
 * @description 把ValueHolder换成ConstructorArgumentValues的
 * @date 11/3/2022 上午12:55
 */
public class ConstructorArgumentValuesTest {

    private Map<Integer, ConstructorArgumentValues.ValueHolder> indexedArgumentValues = new LinkedHashMap<>();

    private List<ConstructorArgumentValues.ValueHolder> genericArgumentValues = new ArrayList<>();

    public Map<Integer, ConstructorArgumentValues.ValueHolder> getIndexedArgumentValues() {
        return indexedArgumentValues;
    }

    public void setIndexedArgumentValues(Map<Integer, ConstructorArgumentValues.ValueHolder> indexedArgumentValues) {
        this.indexedArgumentValues = indexedArgumentValues;
    }

    public List<ConstructorArgumentValues.ValueHolder> getGenericArgumentValues() {
        return genericArgumentValues;
    }

    public void setGenericArgumentValues(List<ConstructorArgumentValues.ValueHolder> genericArgumentValues) {
        this.genericArgumentValues = genericArgumentValues;
    }

    public boolean isEmpty() {
        return (this.indexedArgumentValues.isEmpty() && this.genericArgumentValues.isEmpty());
    }


//    public static class ValueHolder implements BeanMetadataElement {
//
//        @Nullable
//        private Object value;
//
//        @Nullable
//        private String type;
//
//        @Nullable
//        private String name;
//
//        @Nullable
//        private Object source;
//
//        private boolean converted = false;
//
//        @Nullable
//        private Object convertedValue;
//
//        /**
//         * Create a new ValueHolder for the given value.
//         * @param value the argument value
//         */
//        public ValueHolder(@Nullable Object value) {
//            this.value = value;
//        }
//
//        /**
//         * Create a new ValueHolder for the given value and type.
//         * @param value the argument value
//         * @param type the type of the constructor argument
//         */
//        public ValueHolder(@Nullable Object value, @Nullable String type) {
//            this.value = value;
//            this.type = type;
//        }
//
//        /**
//         * Create a new ValueHolder for the given value, type and name.
//         * @param value the argument value
//         * @param type the type of the constructor argument
//         * @param name the name of the constructor argument
//         */
//        public ValueHolder(@Nullable Object value, @Nullable String type, @Nullable String name) {
//            this.value = value;
//            this.type = type;
//            this.name = name;
//        }
//
//        /**
//         * Set the value for the constructor argument.
//         */
//        public void setValue(@Nullable Object value) {
//            this.value = value;
//        }
//
//        /**
//         * Return the value for the constructor argument.
//         */
//        @Nullable
//        public Object getValue() {
//            return this.value;
//        }
//
//        /**
//         * Set the type of the constructor argument.
//         */
//        public void setType(@Nullable String type) {
//            this.type = type;
//        }
//
//        /**
//         * Return the type of the constructor argument.
//         */
//        @Nullable
//        public String getType() {
//            return this.type;
//        }
//
//        /**
//         * Set the name of the constructor argument.
//         */
//        public void setName(@Nullable String name) {
//            this.name = name;
//        }
//
//        /**
//         * Return the name of the constructor argument.
//         */
//        @Nullable
//        public String getName() {
//            return this.name;
//        }
//
//        /**
//         * Set the configuration source {@code Object} for this metadata element.
//         * <p>The exact type of the object will depend on the configuration mechanism used.
//         */
//        public void setSource(@Nullable Object source) {
//            this.source = source;
//        }
//
//        @Override
//        @Nullable
//        public Object getSource() {
//            return this.source;
//        }
//
//        /**
//         * Return whether this holder contains a converted value already ({@code true}),
//         * or whether the value still needs to be converted ({@code false}).
//         */
//        public synchronized boolean isConverted() {
//            return this.converted;
//        }
//
//        /**
//         * Set the converted value of the constructor argument,
//         * after processed type conversion.
//         */
//        public synchronized void setConvertedValue(@Nullable Object value) {
//            this.converted = (value != null);
//            this.convertedValue = value;
//        }
//
//        /**
//         * Return the converted value of the constructor argument,
//         * after processed type conversion.
//         */
//        @Nullable
//        public synchronized Object getConvertedValue() {
//            return this.convertedValue;
//        }
//
//        /**
//         * Determine whether the content of this ValueHolder is equal
//         * to the content of the given other ValueHolder.
//         * <p>Note that ValueHolder does not implement {@code equals}
//         * directly, to allow for multiple ValueHolder instances with the
//         * same content to reside in the same Set.
//         */
//        private boolean contentEquals(ConstructorArgumentValuesTest.ValueHolder other) {
//            return (this == other ||
//                    (ObjectUtils.nullSafeEquals(this.value, other.value) && ObjectUtils.nullSafeEquals(this.type, other.type)));
//        }
//
//        /**
//         * Determine whether the hash code of the content of this ValueHolder.
//         * <p>Note that ValueHolder does not implement {@code hashCode}
//         * directly, to allow for multiple ValueHolder instances with the
//         * same content to reside in the same Set.
//         */
//        private int contentHashCode() {
//            return ObjectUtils.nullSafeHashCode(this.value) * 29 + ObjectUtils.nullSafeHashCode(this.type);
//        }
//
//        /**
//         * Create a copy of this ValueHolder: that is, an independent
//         * ValueHolder instance with the same contents.
//         */
//        public ConstructorArgumentValues.ValueHolder copy() {
//            ConstructorArgumentValues.ValueHolder copy = new ConstructorArgumentValues.ValueHolder(this.value, this.type, this.name);
//            copy.setSource(this.source);
//            return copy;
//        }
//    }
}
