select product_name from CUSTOMERS c
join ORDERS o on c.id = o.customer_id
where lower(name) = lower(:firstName) ;