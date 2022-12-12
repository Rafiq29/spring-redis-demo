package com.herb.springredisdemo.service;

import com.herb.springredisdemo.entity.Invoice;
import com.herb.springredisdemo.error.InvoiceNotFoundException;
import com.herb.springredisdemo.repo.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService{

    @Autowired
    private InvoiceRepository repo;

    @Override
    public Invoice saveInvoice(Invoice inv) {
        return repo.save(inv);
    }

    @Override
    @CachePut(value = "Invoice", key = "#invId")
    public Invoice updateInvoice(Invoice inv, Integer invId) {
        Invoice invoice = repo.findById(invId)
                .orElseThrow(() -> new InvoiceNotFoundException("Invoice Not Found"));
        invoice.setInvAmount(inv.getInvAmount());
        invoice.setInvName(inv.getInvName());
        return repo.save(invoice);
    }

    @Override
    @CacheEvict(value = "Invoice", key = "#invId")
    public void deleteInvoice(Integer invId) {
        Invoice invoice = repo.findById(invId)
                .orElseThrow(() -> new InvoiceNotFoundException("Invoice Not Found"));
        repo.delete(invoice);
    }

    @Override
    @Cacheable(value = "Invoice", key = "#invId")
    public Invoice getOneInvoice(Integer invId) {
        Invoice invoice = repo.findById(invId)
                .orElseThrow(() -> new InvoiceNotFoundException("Invoice Not Found"));
        return invoice;
    }

    @Override
    @Cacheable(value = "Invoice")
    public List<Invoice> getAllInvoices() {
        return repo.findAll();
    }
}