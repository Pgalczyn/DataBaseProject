package org.example.CRUD;

import org.hibernate.Session;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CrudReports {
    public static Long amountOfSoldTicketsLast7Days(Session session) {
        String hqlCount = """
                        SELECT COUNT(pi)
                        FROM PurchaseItem pi
                        WHERE pi.purchase.date >= :lastWeek
                    """;
        LocalDateTime lastWeek = LocalDateTime.now().minusDays(7);

        return session.createQuery(hqlCount, Long.class)
                .setParameter("lastWeek", lastWeek)
                .getSingleResult();
    }

    public static Long totalRevenueLast7Days(Session session) {
        String hqlSum = """
            SELECT SUM(pi.ticket.price)
            FROM PurchaseItem pi
            WHERE pi.purchase.date >= :lastWeek
        """;

        LocalDateTime lastWeek = LocalDateTime.now().minusDays(7);

        Long totalRevenue = session.createQuery(hqlSum, Long.class)
                .setParameter("lastWeek", lastWeek)
                .getSingleResult();

        if (totalRevenue == null) totalRevenue = 0L;

        return totalRevenue;
    }

}
