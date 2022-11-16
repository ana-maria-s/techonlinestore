package com.project.console.XML;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.project.domain.SimpleProduct;
import com.project.domain.Type;
import com.project.store.Store;

public class ProductComparator {
    public List<SimpleProduct> productsToSort(Store onlineStore) {
        List<SimpleProduct> categoryProducts = new ArrayList<>();
        for (Type category : onlineStore.getCategoryList()) {
            categoryProducts.addAll(category.getProductList());
        }
        return categoryProducts;
    }

    private static final Map<String, Comparator<SimpleProduct>> COMPARATOR_MAP = new LinkedHashMap<String, Comparator<SimpleProduct>>() {{
        put("name", Comparator.comparing(SimpleProduct::getName));
        put("price", Comparator.comparing(SimpleProduct::getPrice));
        put("rate", Comparator.comparing(SimpleProduct::getRate));
    }};

    private Comparator<SimpleProduct> ascDescComparator(Map.Entry<String, String> entry) {
        String comparatorName = entry.getKey();
        Comparator<SimpleProduct> comparator = COMPARATOR_MAP.getOrDefault(comparatorName, null);

        if (entry.getValue().equals(Sorter.DESC.toString()) && Objects.nonNull(comparator)) {
            comparator = comparator.reversed();
        }
        return comparator;
    }

    private Comparator<SimpleProduct> buildComparator(Map<String, String> comparatorConfig) throws Exception {
        return comparatorConfig.entrySet().stream()
                .map(this::ascDescComparator)
                .filter(Objects::nonNull)
                .reduce(Comparator::thenComparing)
                .orElseThrow(Exception::new);
    }

    private Stream<SimpleProduct> productStream(Store onlineStore, Comparator<SimpleProduct> comparator) {
        return productsToSort(onlineStore)
                .stream()
                .sorted(comparator);
    }

    public void sortProducts(Store onlineStore) throws Exception {
        XMLParser xmlParserObject = new XMLParser();
        Map<String, String> parserMap = xmlParserObject.getMap();
        Comparator<SimpleProduct> productComparator = buildComparator(parserMap);
        Stream<SimpleProduct> sortStream = productStream(onlineStore, productComparator);
        List<SimpleProduct> products = sortStream.collect(Collectors.toList());
        for (SimpleProduct product : products) {
            System.out.println(product);
        }
    }


    public void mostExpensive(Store onlineStore) {
        List<SimpleProduct> topProductList = productsToSort(onlineStore);
        topProductList.sort((Comparator.comparing(SimpleProduct::getPrice).reversed()));
        for (SimpleProduct mostExpensiveProducts : topProductList.subList(0, 5)) {
            System.out.println(mostExpensiveProducts);
        }
    }
}