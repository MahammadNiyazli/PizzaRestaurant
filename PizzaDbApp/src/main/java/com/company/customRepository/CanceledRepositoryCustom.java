package com.company.customRepository;

import com.company.entity.Canceled;

public interface CanceledRepositoryCustom {
    public Canceled updateCanceled(Canceled c);

    public boolean addCanceled(Canceled u);

    public boolean removeCanceled(int id);

    public Canceled findById(int id);
}
