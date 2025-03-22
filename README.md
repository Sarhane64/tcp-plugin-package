# capacitor-socket-tcp

Socket communication tcp with capacitor

## Install

```bash
npm install capacitor-socket-tcp
npx cap sync
```

## API

<docgen-index>

* [`connect(...)`](#connect)
* [`send(...)`](#send)
* [`close()`](#close)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### connect(...)

```typescript
connect(options: { host: string; port: number; }) => Promise<void>
```

| Param         | Type                                         |
| ------------- | -------------------------------------------- |
| **`options`** | <code>{ host: string; port: number; }</code> |

--------------------


### send(...)

```typescript
send(options: { message: string; }) => Promise<void>
```

| Param         | Type                              |
| ------------- | --------------------------------- |
| **`options`** | <code>{ message: string; }</code> |

--------------------


### close()

```typescript
close() => Promise<void>
```

--------------------

</docgen-api>
